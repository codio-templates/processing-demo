import os, sys, requests, random, re, io, subprocess, shutil
from subprocess import Popen, PIPE, STDOUT

def copy_code_file(file_path, file_name):
  shutil.copyfile(file_path, '.guides/secure/'+file_name)

## check function of code using output - keyboard flag to indicate input type
def check_output(file, arguments, expected_output, keyboard=False):
  expected_output = expected_output.rstrip('\x00')
  #compile and run code with given input
  compile_cmd = "javac " + file
  file_no_ext = os.path.splitext(file)[0]
  if keyboard:
    subprocess.Popen(compile_cmd, shell=True)
    #https://stackoverflow.com/questions/33976094/subprocess-stdin-input
    p = Popen(['java', file_no_ext], stdout=PIPE, stdin=PIPE, stderr=STDOUT)
    student_output = p.communicate(input=str.encode(arguments))[0]
  else:
    subprocess.Popen(compile_cmd, shell=True)
    student_output = subprocess.check_output(['java', file_no_ext]).rstrip()
  #check generated output
  if student_output.decode("utf-8").strip() == expected_output:
    return True
  else:
    return False

## returns file name of code without comments
def strip_comments(text_of_file):
    return re.sub('//.*?\n|/\*.*?\*/', '', str(text_of_file))

#checks for banned keywords
def check_code_for_banned(code_without_comments, list_of_banned):
    for taboo in list_of_banned:
      if taboo in code_without_comments:
        print("BANNED KEYWORD " + taboo + " FOUND")
        return False
    return True

#checks for keywords with limits - takes DICTIONARY
def check_code_for_limited(code_without_comments, dict_of_limited):
    for limited in dict_of_limited:
      if code_without_comments.count(limited) > dict_of_limited[limited]:
        print("LIMITED KEYWORD " + limited + " OVER-USED - USED " + str(code_without_comments.count(limited)) + " TIMES, ONLY ALLOWED " + str(dict_of_limited[limited]))
        return False
      elif code_without_comments.count(limited) < dict_of_limited[limited]:
        print("LIMITED KEYWORD " + limited + " UNDER-USED - USED " + str(code_without_comments.count(limited)) + " TIMES, EXPECTED " + str(dict_of_limited[limited]))
        return False
    return True

#checks for required words
def check_code_for_required(code_without_comments, list_of_required):
    for required in list_of_required:
      if not(required in code_without_comments):
        print("REQUIRED KEYWORD " + required + " NOT USED")
        return False
    return True
    
#checks if the given method is recursive
def check_code_for_recursive_call(code, recursive_method_name, recursive_method_header):
  method = False
  method_opened = False
  recursive_call = False
  opened = 0
  for i in code:
    if "//" in i:
      i = i[:i.index("//")]
    if not(method) and recursive_method_header in i:
      method = True
    if method and method_opened and recursive_method_name in i:
      recursive_call = True
    if method:
      opened += i.count('{')
      opened -= i.count('}')
    if method and not(method_opened) and opened > 0:
      method_opened = True
    if method and method_opened and opened == 0:
      method = False
  return recursive_call