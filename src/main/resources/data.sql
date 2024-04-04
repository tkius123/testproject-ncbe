-- Insert Departments
INSERT INTO department (name) VALUES ('Engineering');
INSERT INTO department (name) VALUES ('Human Resources');
INSERT INTO department (name) VALUES ('Marketing');

-- Insert Employees
-- Engineering Department
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Alice', 'MANAGER', true, (SELECT id FROM department WHERE name ='Engineering' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Bob', 'FLOOR_WORKER', true, (SELECT id FROM department WHERE name ='Engineering' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Max', 'SUPERVISOR', true, (SELECT id FROM department WHERE name ='Engineering' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Nina', 'INTERN', true, (SELECT id FROM department WHERE name ='Engineering' LIMIT 1));

-- Human Resources Department
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Charlie', 'MANAGER', true, (SELECT id FROM department WHERE name ='Human Resources' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Diana', 'FLOOR_WORKER', false, (SELECT id FROM department WHERE name ='Human Resources' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Oliver', 'SUPERVISOR', true, (SELECT id FROM department WHERE name ='Human Resources' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Liam', 'INTERN', true, (SELECT id FROM department WHERE name ='Human Resources' LIMIT 1));

-- Marketing Department
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Eve', 'MANAGER', true, (SELECT id FROM department WHERE name ='Marketing' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Frank', 'FLOOR_WORKER', false, (SELECT id FROM department WHERE name ='Marketing' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Sophia', 'SUPERVISOR', true, (SELECT id FROM department WHERE name ='Marketing' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Mia', 'INTERN', true, (SELECT id FROM department WHERE name ='Marketing' LIMIT 1));

-- Executive across departments
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Isabella', 'EXECUTIVE', true, (SELECT id FROM department WHERE name ='Engineering' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Ethan', 'EXECUTIVE', true, (SELECT id FROM department WHERE name ='Human Resources' LIMIT 1));
INSERT INTO employee (name, type, is_full_time, department_id) VALUES ('Lucas', 'EXECUTIVE', true, (SELECT id FROM department WHERE name ='Marketing' LIMIT 1));

-- Insert WorkLogs for a specific week (week_id = 1)
-- Week of January 1, 2024 to January 7, 2024
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 40, (SELECT id FROM employee WHERE name ='Alice' LIMIT 1));
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 42, (SELECT id FROM employee WHERE name ='Bob' LIMIT 1));
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 38, (SELECT id FROM employee WHERE name ='Charlie' LIMIT 1));
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 20, (SELECT id FROM employee WHERE name ='Diana' LIMIT 1));
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 40, (SELECT id FROM employee WHERE name ='Eve' LIMIT 1));
INSERT INTO work_log (week_id, week_start, week_end, hours_worked, employee_id) VALUES (1, '2024-01-01', '2024-01-07', 25, (SELECT id FROM employee WHERE name ='Frank' LIMIT 1));
