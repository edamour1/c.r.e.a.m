package cream.util;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import cream.model.Cart;
import cream.model.Colors;
import cream.model.Order;
import cream.model.OrderHistory;
import cream.model.Product;
import cream.model.SizeS;
import cream.model.Sleeves;
import cream.model.Types;
import cream.model.User;
import cream.repository.CartDao;
import cream.repository.ColorsDao;
import cream.repository.OrderDao;
import cream.repository.OrderHistoryDao;
import cream.repository.ProductDao;
import cream.repository.SizesDao;
import cream.repository.SleevesDao;
import cream.repository.TypesDao;
import cream.repository.UserDao;

public class Test {
	public static void main(String args[]) throws SQLException {
		System.out.println("Monkey");
	UserDao userDao = new UserDao();

		System.out.println(userDao.usernameExist("Twan"));
		System.out.println("Jewish");
	}

}
