package com.travelAgency.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpHotel", namespace = "http://db.travelAgency.com.java.main")
public class NpHotel extends it.codegen.Savable
{
 	private int hotelId;
	private String hotelName;
 	private int status;

	public NpHotel()
	{
	}

	public void checkValidity() throws SavingSQLException
	{
	}
	/**
	 * This insert/modify or update depending on the action
	 */
	public void save( Connection con ) throws SavingSQLException
	{
		String action = "";
		try
		{
			if( this.status == Savable.NEW )
			{
				action = "Inserting";
				checkValidity();
				insert(con);
			}
			else if ( this.status == Savable.MODIFIED )
			{
				action = "Updating";
				checkValidity();
 				update(con);
 			}
			else if (this.status == Savable.DELETED )
			{
				action = "Deleting";
				checkValidity();
				delete(con);
			}
			else if( this.status == Savable.UNCHANGED )
			{
				//Do nothing
			}
			else
			{
				throw new SavingSQLException("Incorret setting of Status flag!");
			}
		}
		catch( SQLException se )
		{
			se.printStackTrace();
			throw new SavingSQLException( "Error in "+ action +
							se.getMessage(),
							se.getSQLState(),
							se.getErrorCode() );
		}
 	}
	/**
	 * This inserts the .........
	 */
	private void insert( Connection con ) throws SQLException
	{
		String str = "INSERT INTO NP_HOTEL ( " 
 		 + "HOTEL_ID, "
		 + "HOTEL_NAME )VALUES(?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.hotelId );
		ps.setString( ++count, this.hotelName );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM NP_HOTEL WHERE "
		 + "HOTEL_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.hotelId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE NP_HOTEL SET "
		 + "HOTEL_NAME = ? WHERE "
		 + "HOTEL_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setString( ++count, this.hotelName );
		ps.setInt( ++count, this.hotelId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.hotelId = rs.getInt( "HOTEL_ID" );
		this.hotelName = rs.getString( "HOTEL_NAME" );


	}

	public int getHotelId()
	{
		return this.hotelId;
	}

	public void setHotelId( int hotelId )
	{
		this.hotelId = hotelId;
	}

	public String getHotelName()
	{
		return this.hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}

}
