SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'd7j6pcgtc8qq5s'
  AND pid <> pg_backend_pid();