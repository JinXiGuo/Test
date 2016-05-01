package test;

public class DBA
{
	java.sql.Statement stm1 = null;
	java.sql.ResultSet rs = null;
	public int colCount = 0;
	public String oper_name = "";

	public java.sql.Connection conn = null;
	boolean status = false;
	public String err = "";
	String defaultDb = "boss";

	public DBA() throws Exception
	{
		try
		{
			javax.naming.Context ctx = new javax.naming.InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("java:comp/env/jdbc/" + this.defaultDb);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stm1 = conn.createStatement();
			status = true;
		} catch (Exception e)
		{
			status = false;
			err = e.toString();
			throw e;
		}
	}

	public DBA(String db) throws Exception
	{
		try
		{
			javax.naming.Context ctx = new javax.naming.InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("java:comp/env/jdbc/" + db);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stm1 = conn.createStatement();
			status = true;
		} catch (Exception e)
		{
			status = false;
			err = e.toString();
			throw e;
		}
	}

	public DBA son() throws Exception
	{
		try
		{
			java.sql.Statement stm2 = conn.createStatement();
			return new DBA(stm2, oper_name);
		} catch (Exception e)
		{

			throw e;
		}
	}

	public DBA(java.sql.Statement stm1, String oper_name)
	{
		this.stm1 = stm1;
		this.oper_name = oper_name;
	}

	public void commit() throws Exception
	{
		try
		{
			conn.commit();
		} catch (Exception e)
		{
			throw e;
		}
	}

	public void rollback() throws Exception
	{
		try
		{
			conn.rollback();
		} catch (Exception e)
		{
			throw e;
		}
	}

	@SuppressWarnings("unused")
	public String parseTable()
	{

		String str1 = "";
		int rowid = 0;
		StringBuffer re1 = new StringBuffer();
		re1.append("<table style=display:inline class=t4 cellpadding=0 cellspacing=1 style=border-collapse:collapse border=1><tr><td>");
		for (int i = 1; i <= colCount; i++)
		{
			if (i != 1)
				re1.append("</td><td>");
			try
			{
				re1.append(rs.getMetaData().getColumnName(i));
			} catch (Exception e)
			{
			}
		}// for
		try
		{
			while (rs.next())
			{
				re1.append("</tr><tr><td>");
				rowid++;
				for (int i = 1; i <= colCount; i++)
				{
					if (i != 1)
						re1.append("</td><td>");
					str1 = rs.getString(i);
					if (str1 != null)
					{
						// str1=str1.replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\"").replaceAll("\t","\\\\\t").replaceAll("\r\n","\\\\r\\\\n").replaceAll("\n","\\\\n");
						re1.append(str1);
					}

				}

			}
		} catch (Exception e)
		{
		}
		re1.append("</tr></table>");
		return re1.toString();
	}

	@SuppressWarnings("unused")
	public String parseXML()
	{
		String str1 = "";
		int rowid = 0;
		StringBuffer re1 = new StringBuffer();
		for (int i = 1; i <= colCount; i++)
		{
			if (i != 1)
				re1.append("\t");
			try
			{
				re1.append(rs.getMetaData().getColumnName(i));
			} catch (Exception e)
			{
			}
		}// for
		try
		{
			while (rs.next())
			{
				re1.append("\r\n");
				rowid++;
				for (int i = 1; i <= colCount; i++)
				{
					if (i != 1)
						re1.append("\t");
					str1 = rs.getString(i);
					if (str1 != null)
					{
						// str1=str1.replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\"").replaceAll("\t","\\\\t").replaceAll("\r\n","\\\\r\\\\n").replaceAll("\n","\\\\n");
						// str1=str1.replaceAll(" ","gs_kongge");
						str1 = java.net.URLEncoder.encode(str1, "UTF-8").replaceAll("\\+", "%20");
						// str1=str1.replaceAll("gs_kongge"," ");

						re1.append(str1);
					}

				}

			}
		} catch (Exception e)
		{
		}
		return re1.toString();
	}

	public void query(String str1) throws Exception
	{
		try
		{
			// System.out.println(str1);
			rs = stm1.executeQuery(str1);
			colCount = rs.getMetaData().getColumnCount();

		} catch (Exception e)
		{
			rs = null;
			System.out.println(e.toString());
			throw e;

		}
	}

	public void query(String str1, int limit1, int limit2) throws Exception
	{
		try
		{
			str1 += " limit " + String.valueOf(limit1) + "," + String.valueOf(limit2);
			// System.out.println(str1);

			rs = stm1.executeQuery(str1);
			colCount = rs.getMetaData().getColumnCount();

		} catch (Exception e)
		{
			rs = null;
			System.out.println(e.toString());
			throw e;

		}
	}

	public void cmd_nolog(String str1) throws Exception
	{
		try
		{
			// System.out.println(str1);
			stm1.execute(str1);

		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw e;
		}
	}

	public void cmd(String str1) throws Exception
	{
		try
		{
			// System.out.println(str1);
			stm1.execute(str1);
			stm1.execute("insert into action_log(op_time,oper_name,sql_text) values(sysdate,'" + oper_name + "','" + str1.replaceAll("'", "''") + "')");
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw e;
		}
	}

	public boolean fetch() throws Exception
	{
		try
		{
			return this.next();
		} catch (Exception e)
		{
			throw e;
		}
	}

	public boolean next() throws Exception
	{
		try
		{
			if (rs != null)
			{
				return rs.next();
			} else
			{
				return false;
			}
		} catch (Exception e)
		{
			throw e;
		}
	}

	public String getString(String str1) throws Exception
	{
		return this.get(str1);
	}

	public String get(int str1) throws Exception
	{
		String tmp1;
		try
		{
			tmp1 = rs.getString(str1) == null ? "" : rs.getString(str1);
		} catch (Exception e)
		{
			throw e;
		}
		return tmp1;
	}

	public String get(String str1) throws Exception
	{
		String tmp1;
		try
		{
			tmp1 = rs.getString(str1) == null ? "" : rs.getString(str1);
		} catch (Exception e)
		{
			tmp1 = e.toString();
			throw e;
		}
		return tmp1;
	}

	public int getInt(String str1) throws Exception
	{
		try
		{
			return rs.getInt(str1);
		} catch (Exception e)
		{
			throw e;
		}
	}

	public String getColName(int i) throws Exception
	{
		try
		{
			return rs.getMetaData().getColumnName(i);
		} catch (Exception e)
		{
			throw e;
		}
	}

	public void close() throws Exception
	{
		try
		{
			stm1.close();
		} catch (Exception e)
		{
			throw e;
		}
	}

	public void die() throws Exception
	{
		try
		{
			conn.commit();
			conn.close();
			status = false;
		} catch (Exception e)
		{
			throw e;
		}
	}

}// class dba