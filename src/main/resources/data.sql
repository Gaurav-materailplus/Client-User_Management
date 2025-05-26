-- Insert Clients
INSERT INTO client (id, name, industry, description) VALUES
  ('11111111-1111-1111-1111-111111111111', 'Acme Corp', 'Finance', 'A sample client'),
  ('22222222-2222-2222-2222-222222222222', 'Beta Inc', 'Tech', 'Another client');

-- Insert Users
INSERT INTO app_user (id, email, full_name, password_hash, role, is_active) VALUES
  ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'jane.doe@example.com', 'Jane Doe', 'hashedpassword', 'CLIENT_USER', true),
  ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'john.manager@example.com', 'John Manager', 'hashedpassword', 'MANAGER', true);

-- Map Users to Clients
INSERT INTO user_tenant_map (id, user_id, client_id) VALUES
  ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-1111-1111-1111-111111111111'),
  ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '22222222-2222-2222-2222-222222222222'); 