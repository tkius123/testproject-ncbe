-- Drop existing tables to start fresh
DROP TABLE IF EXISTS work_log;
DROP TABLE IF EXISTS week_long;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

-- Create Department table
CREATE TABLE department (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255)
);

-- Create Employee table
CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          type VARCHAR(50),
                          is_full_time BOOLEAN,
                          department_id BIGINT,
                          FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Create WeekLong table
CREATE TABLE week_long (
                           id SERIAL PRIMARY KEY,
                           week_start DATE,
                           week_end DATE
);

-- Create WorkLog table
CREATE TABLE work_log (
                          id SERIAL PRIMARY KEY,
                          week_long_id BIGINT,
                          employee_id BIGINT,
                          hours_worked DOUBLE PRECISION,
                          FOREIGN KEY (week_long_id) REFERENCES week_long(id),
                          FOREIGN KEY (employee_id) REFERENCES employee(id)
);
