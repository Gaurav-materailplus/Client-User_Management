CREATE TABLE IF NOT EXISTS client (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  industry VARCHAR(255),
  description TEXT
);

CREATE TABLE IF NOT EXISTS app_user (
  id UUID PRIMARY KEY,
  email VARCHAR(255),
  full_name VARCHAR(255),
  password_hash VARCHAR(255),
  role VARCHAR(50),
  is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS user_tenant_map (
  id UUID PRIMARY KEY,
  user_id UUID REFERENCES app_user(id),
  client_id UUID REFERENCES client(id)
);
