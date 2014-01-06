
# Hash table for mapping emp name to manager name
hash_table = dict()
# Just for sake of simplicity consider it as list of lists
# Structure of the data is emp id , emp name and manager name
# Considering all employees have unique name

data = [
          [1,"aditya","pn"],
          [2,"pradeep","pn"],
          [3,"quora","facebook"],
          [4,"gmail","outlook"]
       ]
def make_data(data):
    global hash_table
    for emp in data:
        emp_name = emp[1]
        emp_manager = emp[2]        
        hash_table[emp_name] = emp_manager

def api(employee_name):
    global hash_table
    print hash_table.get(employee_name)

make_data(data)
# input is name of the employee
api("aditya")
        
