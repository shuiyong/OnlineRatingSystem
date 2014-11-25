begin;

insert into MYUSER values (1, 'test1', 'Lecturer', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (2, 'test2', 'Submitter', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (3, 'test3', 'Candidate Reviewer 1', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (4, 'test4', 'Candidate Reviewer 2', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (5, 'test5', 'Candidate Reviewer 3', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (6, 'test6', 'RPM1', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');
insert into MYUSER values (7, 'test7', 'RPM2', False, 'Test', '$2a$10$O7DfALJgETxtT4C.n2b/4eD.BPqwIerh2mpuDxxe8GIATY8niTpLe');

insert into COURSE values (1, 'Software Engineering', 1);

-- id, course_id
insert into TEAM values (1, 1);
insert into TEAM values (2, 1);

-- id, team_id, user_id
insert into TEAMMEMBER values (1, 1, 2);
insert into TEAMMEMBER values (2, 1, 7);
insert into TEAMMEMBER values (3, 2, 3);
insert into TEAMMEMBER values (4, 2, 4);
insert into TEAMMEMBER values (5, 2, 5);
insert into TEAMMEMBER values (6, 2, 6);

-- id, active, team_id, teammember_id
insert into RPM values (1, true, 1, 6);
insert into RPM values (2, true, 2, 2);

commit;