select ID, 
case
    when rn <= total*0.25 then 'CRITICAL'
    when rn <= total*0.5 then 'HIGH'
    when rn <= total*0.75 then 'MEDIUM'
    else 'LOW'
end as COLONY_NAME
from ( select ID, ROW_NUMBER() OVER(order by SIZE_OF_COLONY desc) as rn, count(*) OVER() AS total from ECOLI_DATA) b
ORDER BY ID;