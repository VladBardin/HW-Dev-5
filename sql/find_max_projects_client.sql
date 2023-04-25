SELECT CLIENT.NAME,
COUNT(project.CLIENT_ID) as PROJECT_COUNT from CLIENT, project
WHERE CLIENT.ID =project.CLIENT_ID
GROUP BY name HAVING COUNT(project.client_id) IN
(SELECT COUNT(client_id)
FROM project
GROUP BY client_id
order by count(CLIENT_ID) desc LIMIT 1
);