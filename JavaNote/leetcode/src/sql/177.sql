
/*
177. 第N高的薪水

思路:
    1. 属于176的变种 解法基本一样
    2. 需要注意 sql 中function 的使用

*/


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
      set N = N-1;
RETURN (
    # Write your MySQL query statement below.

      select ifnull((select distinct salary from employee order by salary desc limit N,1),null) as getNthHighestSalary

    );
END