-- Insert sample departments
INSERT INTO department (name) VALUES
                                  ('Sales'),
                                  ('Marketing'),
                                  ('Finance'),
                                  ('Human Resources'),
                                  ('Information Technology');

-- Insert sample employees
INSERT INTO employee (name, type, is_full_time, department_id) VALUES
                                                                   ('John Doe', 'FLOOR_WORKER', true, 1),
                                                                   ('Jane Smith', 'INTERN', false, 2),
                                                                   ('Michael Johnson', 'MANAGER', true, 3),
                                                                   ('Emily Davis', 'SUPERVISOR', true, 1),
                                                                   ('David Brown', 'FLOOR_WORKER', true, 2),
                                                                   ('Sarah Wilson', 'MANAGER', false, 3),
                                                                   ('Chris Lee', 'INTERN', true, 4),
                                                                   ('Jennifer Taylor', 'EXECUTIVE', true, 5),
                                                                   ('Matthew Anderson', 'FLOOR_WORKER', true, 1),
                                                                   ('Amanda Martinez', 'MANAGER', true, 2),
                                                                   ('James Rodriguez', 'SUPERVISOR', false, 3),
                                                                   ('Olivia Hernandez', 'FLOOR_WORKER', true, 4),
                                                                   ('Sophia Wright', 'INTERN', true, 5),
                                                                   ('Logan Green', 'MANAGER', false, 1),
                                                                   ('Liam Hill', 'EXECUTIVE', true, 2),
                                                                   ('Ethan Adams', 'FLOOR_WORKER', true, 3),
                                                                   ('Isabella Baker', 'MANAGER', true, 4),
                                                                   ('William Carter', 'FLOOR_WORKER', false, 5),
                                                                   ('Evelyn Foster', 'INTERN', true, 1);

-- Insert sample week long entries
INSERT INTO week_long (week_start, week_end) VALUES
                                                 ('2024-01-01', '2024-01-07'),
                                                 ('2024-01-08', '2024-01-14'),
                                                 ('2024-01-15', '2024-01-21'),
                                                 ('2024-01-22', '2024-01-28'),
                                                 ('2024-01-29', '2024-02-04'),
                                                 ('2024-02-05', '2024-02-11'),
                                                 ('2024-02-12', '2024-02-18'),
                                                 ('2024-02-19', '2024-02-25'),
                                                 ('2024-02-26', '2024-03-03'),
                                                 ('2024-03-04', '2024-03-10');

-- Insert sample work logs
INSERT INTO work_log (week_long_id, employee_id, hours_worked) VALUES
                                                                   (1, 1, 40),
                                                                   (1, 2, 20),
                                                                   (2, 3, 35),
                                                                   (2, 4, 30),
                                                                   (3, 5, 25),
                                                                   (3, 6, 15),
                                                                   (4, 7, 40),
                                                                   (4, 8, 20),
                                                                   (5, 9, 35),
                                                                   (5, 10, 30),
                                                                   (6, 11, 25),
                                                                   (6, 12, 15),
                                                                   (7, 13, 40),
                                                                   (7, 14, 20),
                                                                   (8, 15, 35),
                                                                   (8, 16, 30),
                                                                   (9, 17, 25),
                                                                   (9, 18, 15),
                                                                   (10, 19, 40);

