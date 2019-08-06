CREATE TABLE user_  
( user_id number(10) NOT NULL,  
  first_name varchar2(50) NOT NULL,  
  last_name varchar2(50) NOT NULL,
  email varchar2(50) NOT NULL,
  phone_number number(10),
  is_admin number(10) NOT NULL,
  username varchar2(50) NOT NULL
  password_ varchar2(50) NOT NULL;

  PRIMARY KEY (user_id) 
);

CREATE SEQUENCE user_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;


CREATE TABLE colors  
( color_id number(10) NOT NULL,  
  color varchar2(50) NOT NULL,  
  PRIMARY KEY (color_id) 
);

CREATE SEQUENCE color_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE type_s  
( type_id number(10) NOT NULL,  
  type_name varchar2(50) NOT NULL,  
  PRIMARY KEY (type_id) 
);

CREATE SEQUENCE types_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE sizes  
( size_id number(10) NOT NULL,  
  size_name varchar2(50) NOT NULL,  
  PRIMARY KEY (size_id) 
);

CREATE SEQUENCE size_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE product  
( product_id number(10) NOT NULL,  
  type_ number(10) NOT NULL,  
  size_ number(10) NOT NULL,  
  color number(10) NOT NULL,  
  price decimal(5,2) NOT NULL,  
  qty number(10) NOT NULL,
  picture_file_path varchar2(100) NOT NULL,  
  
  PRIMARY KEY (product_id),
  FOREIGN KEY (type_) REFERENCES Type_s(type_id),
  FOREIGN KEY (size_) REFERENCES Size_s(size_id),
  FOREIGN KEY (color) REFERENCES Colors(color_id)
);

CREATE SEQUENCE product_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE Order_ (
    order_id number(10) NOT NULL, 
    product_id number(10) NOT NULL,  
    qty number(10) NOT NULL,
    cart_id number(10) NOT NULL,
  
  PRIMARY KEY (order_id),
  FOREIGN KEY (product_id) REFERENCES Product(product_id),
  FOREIGN KEY (cart_id) REFERENCES Cart(cart_id)
);

CREATE SEQUENCE order_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE Order_history  
(   order_histry_id number(10) NOT NULL, 
    cart_id number(10) NOT NULL,  
    date_ date not null,
    street_address varchar2(50) NOT NULL,  
    city varchar2(50) NOT NULL,  
    state_ varchar2(50) NOT NULL,  
    zip_code varchar2(50) NOT NULL,  
  
  PRIMARY KEY (order_history_id),
  FOREIGN KEY (cart_id) REFERENCES cart(cart_id)
);

CREATE SEQUENCE order_history_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE Cart  
( cart_id number(10) NOT NULL,  
  user_id number(10) NOT NULL,  

  PRIMARY KEY (cart_id),
  FOREIGN KEY (user_id) REFERENCES User_(user_id)
);

CREATE SEQUENCE cart_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE TABLE sleeves  
( sleeve_id number(10) NOT NULL,  
  sleeve_name varchar2(50) NOT NULL,  

  PRIMARY KEY (sleeve_id) 
);

CREATE SEQUENCE sleeves_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;


<!-- Don't use -->
CREATE TABLE t_shirts  
( shirt_id number(10) NOT NULL,  
  sleeve varchar2(50) NOT NULL,
  size_ number(10) NOT NULL,
  color number(10) NOT NULL,
  price number(10) NOT NULL,
  qty number(10) NOT NULL,
  PRIMARY KEY (shirt_id),
  FOREIGN KEY (size_) REFERENCES Size_s(SIZE_ID),
  FOREIGN KEY (color) REFERENCES Colors(color_id)
);

CREATE TABLE pants  
( pants_id number(10) NOT NULL,  
  type_ varchar2(50) NOT NULL,
  size_ number(10) NOT NULL,
  color number(10) NOT NULL,
  price number(10) NOT NULL,
  qty number(10) NOT NULL,
  PRIMARY KEY (pants_id),
  FOREIGN KEY (size_) REFERENCES Size_s(SIZE_ID),
  FOREIGN KEY (color) REFERENCES Colors(color_id)
);

CREATE TABLE hats
( hat_id number(10) NOT NULL,  
  type_ varchar2(50) NOT NULL,
  size_ number(10) NOT NULL,
  color number(10) NOT NULL,
  price number(10) NOT NULL,
  qty number(10) NOT NULL,
  PRIMARY KEY (hat_id),
  FOREIGN KEY (size_) REFERENCES Size_s(SIZE_ID),
  FOREIGN KEY (color) REFERENCES Colors(color_id)
);

<!-- Don't use -->

INSERT INTO colors (
    color_id,
    color
) VALUES (
    0,
    'white'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    1,
    'black'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    3,
    'brown'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    4,
    'red'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    5,
    'blue'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    6,
    'yellow'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    7,
    'purple'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    8,
    'orange'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    9,
    'green'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    10,
    'gold'
);

INSERT INTO colors (
    color_id,
    color
) VALUES (
    11,
    'silver'
);

##sleevs - short, tanks, 3/4 sleeves/ long, sweat shirt, 