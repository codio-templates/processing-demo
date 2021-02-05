import os, sys, requests, random, re, io, subprocess
sys.path.append('/usr/share/codio/assessments')
from lib.grade import send_partial_v2, FORMAT_V2_MD, FORMAT_V2_HTML, FORMAT_V2_TXT
#change for correct language
import java_grader_methods as jgm

## uses the above method to grade programs
def main():
    path = 'code/introObjects/'
    file = 'Exercise1.java'
    student_code = os.path.join(path, file)
    points = 100
    feedback = ''
    
    #check for keywords
    with open(student_code) as code:
      code_without_comments = jgm.strip_comments(code.read())
      
      check_class = {'class':2}
      if not(jgm.check_code_for_limited(code_without_comments, check_class)):
        feedback += 'Did not use <code>class</code> keyword in user-defined class \n'
        points -= 25
        
      check_string = {'String':2}
      if not(jgm.check_code_for_limited(code_without_comments, check_string)):
        feedback += 'Did not use <code>String</code> keyword in user-defined class \n'
        points -= 25
        
      class_name = ['PracticeClass']
      if not(jgm.check_code_for_required(code_without_comments, class_name)):
        feedback += 'Did not name the user-defined class <code>PracticeClass</code> \n'
        points -= 25
        
      attribute_name = ['date']
      if not(jgm.check_code_for_required(code_without_comments, attribute_name)):
        feedback += 'Did not name the attribute <code>date</code> \n'
        points -= 25
        
    feedback += '<h2>On this question you earned {}% out of 100%</h2>'.format(points)
    res = send_partial_v2(points, feedback, FORMAT_V2_HTML)
    exit(0 if res else 1)

if __name__ == "__main__":
    main()
    