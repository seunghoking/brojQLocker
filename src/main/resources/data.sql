-- 락커룸 데이터
INSERT INTO locker_room (room_code, room_name, center_id) VALUES ('MEN01', '남성 락커룸', 1);
INSERT INTO locker_room (room_code, room_name, center_id) VALUES ('WOMEN01', '여성 락커룸', 1);

-- 락커 데이터
INSERT INTO locker (locker_number, locker_room_id, status) VALUES ('A001', 1, 'AVAILABLE');
INSERT INTO locker (locker_number, locker_room_id, status) VALUES ('A002', 1, 'AVAILABLE');
INSERT INTO locker (locker_number, locker_room_id, status) VALUES ('A003', 1, 'OCCUPIED');
INSERT INTO locker (locker_number, locker_room_id, status, customer_id) VALUES ('A004', 1, 'OCCUPIED', 123);
INSERT INTO locker (locker_number, locker_room_id, status) VALUES ('B001', 2, 'AVAILABLE');
INSERT INTO locker (locker_number, locker_room_id, status) VALUES ('B002', 2, 'AVAILABLE');