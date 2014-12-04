begin;

insert into MYUSER values (100000, 'test1', 'Lecturer', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (200000, 'test2', 'Submitter', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (300000, 'test3', 'Candidate Reviewer 1', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (400000, 'test4', 'Candidate Reviewer 2', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (500000, 'test5', 'Candidate Reviewer 3', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (600000, 'test6', 'RPM1', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (700000, 'test7', 'RPM2', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (800000, 'test8', 'Admin', True, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');

insert into COURSE values (100000, 'Software Engineering', 100000);

-- id, course_id
insert into TEAM values (100000, 100000);
insert into TEAM values (200000, 100000);

-- id, team_id, user_id
insert into TEAMMEMBER values (100000, 100000, 200000);
insert into TEAMMEMBER values (200000, 100000, 700000);
insert into TEAMMEMBER values (300000, 200000, 300000);
insert into TEAMMEMBER values (400000, 200000, 400000);
insert into TEAMMEMBER values (500000, 200000, 500000);
insert into TEAMMEMBER values (600000, 200000, 600000);

-- id, active, team_id, teammember_id
insert into RPM values (100000, true, 100000, 600000);
insert into RPM values (200000, true, 200000, 200000);

commit;