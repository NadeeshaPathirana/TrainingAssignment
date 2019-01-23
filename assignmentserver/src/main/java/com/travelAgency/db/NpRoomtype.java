package com.travelAgency.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpRoomtype", namespace = "http://db.travelAgency.com")
public class NpRoomtype extends it.codegen.Savable
{
 	private int roomTypeId;
	private String typeName;
	private int maxAdults;
	private int npHotelHotelId;
 	private int status;

	public NpRoomtype()
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
		String str = "INSERT INTO NP_ROOMTYPE ( " 
 		 + "ROOM_TYPE_ID, "
		 + "TYPE_NAME, "
		 + "MAX_ADULTS, "
		 + "NP_HOTEL_HOTEL_ID )VALUES(?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.roomTypeId );
		ps.setString( ++count, this.typeName );
		ps.setInt( ++count, this.maxAdults );
		ps.setInt( ++count, this.npHotelHotelId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM NP_ROOMTYPE WHERE "
		 + "ROOM_TYPE_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.roomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE NP_ROOMTYPE SET "
		 + "TYPE_NAME = ?, "
		 + "MAX_ADULTS = ?, "
		 + "NP_HOTEL_HOTEL_ID = ? WHERE "
		 + "ROOM_TYPE_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setString( ++count, this.typeName );
		ps.setInt( ++count, this.maxAdults );
		ps.setInt( ++count, this.npHotelHotelId );
		ps.setInt( ++count, this.roomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.roomTypeId = rs.getInt( "ROOM_TYPE_ID" );
		this.typeName = rs.getString( "TYPE_NAME" );
		this.maxAdults = rs.getInt( "MAX_ADULTS" );
		this.npHotelHotelId = rs.getInt( "NP_HOTEL_HOTEL_ID" );


	}

	public int getRoomTypeId()
	{
		return this.roomTypeId;
	}

	public void setRoomTypeId( int roomTypeId )
	{
		this.roomTypeId = roomTypeId;
	}

	public String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName( String typeName )
	{
		this.typeName = typeName;
	}

	public int getMaxAdults()
	{
		return this.maxAdults;
	}

	public void setMaxAdults( int maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	public int getNpHotelHotelId()
	{
		return this.npHotelHotelId;
	}

	public void setNpHotelHotelId( int npHotelHotelId )
	{
		this.npHotelHotelId = npHotelHotelId;
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
