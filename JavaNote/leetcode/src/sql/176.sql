/*

176. 第二高的薪水

描述:
    一张表中查询排行第二的记录中的数据 , 如果没有就显示null

思路:
    1. 没有就显示null 使用 ifnull(data1 , data2 ) ---- 如果data1 为null 就将 data2 作为返回值返回
    2. 排行第二 我们可以先根据薪水排序 之后 通过 limit 关键字 进行截取 ----  limit n1 , n2 从 第n1 位开始 截取 n2 个记录
    3. 根据薪水排序之后可能会出现 重复数据 例如 最高的薪水有多个记录所以我们要 对数据去冲
            --  distinct 关键字 --- 写在所有的字段前面 将 distinct 关键字后面的所有字段都作为去重字段进行去重
    4. order by 进行排序  顺序显示 asc  倒序显示  desc


*/

select ifnull((select distinct salary from employee order by salary desc limit 1,1),null) as SecondHighestSalary;