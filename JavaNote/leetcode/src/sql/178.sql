

/*

 mysql 中的排序函数


    1. rank() over(排序逻辑)        并排排序 会跳过序号                                 1,1,3,4,4,6
    2. dense_rank() over(排序逻辑)  并排排序 不会跳过序号                         1,1,2,2,3,4
    3. number() over(排序逻辑)      顺序排序 不会跳过序号,排序相同的也会按序编号           1,2,3,4,5,6



 */


select score , dense_rank() over(order by score desc) 'rank' from Scores