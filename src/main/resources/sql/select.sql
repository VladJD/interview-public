select accounts.id, accounts.first_name, sum(transfers.amount) total
from accounts join transfers  on accounts.id = transfers.source_id
where transfers.transfer_time >= '2019-01-01'
group by accounts.id
having sum(transfers.amount) > 1000