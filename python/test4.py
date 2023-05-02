class MyEx(Exception):
  def __init__(self, msg):
    Exception.__init__(self, msg+msg)
    self.args = (msg,)
 
try:
  raise MyEx('wrong!')
except Exception as e:
  print(e)
  800
  1450
  2800
  190.000