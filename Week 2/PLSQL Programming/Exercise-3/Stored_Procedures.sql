CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    account_type VARCHAR2(20) CHECK (account_type IN ('SAVINGS', 'CURRENT')),
    balance NUMBER(10, 2),
    interest_rate NUMBER(5, 2) DEFAULT 0.00
);

CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(25),
    department VARCHAR2(15),
    salary NUMBER(10, 2),
    performance_rating NUMBER(2, 1)
);

-- For logging tranfers
CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    from_account NUMBER,
    to_account NUMBER,
    amount NUMBER(10, 2),
    transaction_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    status VARCHAR2(20)
);

INSERT INTO accounts VALUES (1001, 1, 'SAVINGS', 5000.00, 1.00);
INSERT INTO accounts VALUES (1002, 1, 'CURRENT', 10000.00, 0.00);
INSERT INTO accounts VALUES (1003, 2, 'SAVINGS', 7500.00, 1.00);
INSERT INTO accounts VALUES (1004, 3, 'SAVINGS', 12000.00, 1.00);

INSERT INTO employees VALUES (101, 'Trisha Basak', 'HR', 50000.00, 4.5);
INSERT INTO employees VALUES (102, 'Ranvir Sastry', 'Finance', 60000.00, 3.8);
INSERT INTO employees VALUES (103, 'Arhaan Sama', 'IT', 70000.00, 4.2);
INSERT INTO employees VALUES (104, 'AYasmin Jha', 'Finance', 55000.00, 3.5);

set pagesize 500;
set linesize 500;

Select * from accounts;
Select * from employees;


--Scenario-1
CREATE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Applying 1% interest to all savings accounts
    UPDATE accounts
    SET balance = balance + (balance * interest_rate / 100)
    WHERE account_type = 'SAVINGS';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(CHR(10)||'Monthly interest applied to all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END;
/
EXEC ProcessMonthlyInterest;
Select * from accounts; 


-- Scenario-2 :  Update salary by adding a bonus percentage for a given department
CREATE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(CHR(10)||p_bonus_percentage||'% bonus applied to employees in ' || p_department || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating bonuses: ' || SQLERRM);
END;
/
EXEC UpdateEmployeeBonus('Finance',5);
Select * from employees;

--Scenario-3
    
CREATE SEQUENCE trans_seq
    start with 1
    increment by 1
    minvalue 0
    maxvalue 100
    nocycle;
    
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER,
    status OUT VARCHAR2
) AS
    balance NUMBER;
BEGIN
    SELECT balance INTO balance
    FROM accounts
    WHERE account_id = from_account;
    
    IF balance >= amount THEN
        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_account;

        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_account;
        
        -- Log the transaction
        INSERT INTO transactions (transaction_id, from_account, to_account, amount, status)
        VALUES (trans_seq.NEXTVAL, from_account, to_account, amount, 'SUCCESS');
        
        COMMIT;
        status := 'SUCCESS';
        DBMS_OUTPUT.PUT_LINE(CHR(10)||'Transfer successful.');
    ELSE
        INSERT INTO transactions (transaction_id, from_account, to_account, amount, status)
        VALUES (trans_seq.NEXTVAL, from_account, to_account, amount, 'FAILED');
        
        status := 'FAILED - Insufficient balance';
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        status := 'ERROR - ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE('Error in transfer: ' || SQLERRM);
END;
/
DECLARE
    status VARCHAR2(100);
BEGIN
    TransferFunds(1001,1003,1000,status);
    DBMS_OUTPUT.PUT_LINE('Status: ' || status);
END;
/
show errors procedure TransferFunds;
Select * from accounts;
Select * from transactions;
