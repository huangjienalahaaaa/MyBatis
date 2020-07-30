# v7.2  第三天 



## 多表查询 --- 
 
*  多对多


需求：

select * from user u,role r,user_role ur where u.id = ur.uid and r.id = ur.rid 


> 现在我们：站在角色的角度来查询信息



select r.*,u.username from user u,role r,user_role ur where u.id = ur.uid and r.id = ur.rid 




 



