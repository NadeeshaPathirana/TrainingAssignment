package com.travelAgency.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpContractRoomType", namespace = "http://db.travelAgency.com.java.main")
public class NpContractRoomType extends it.codegen.Savable
{
 	private int contractContractId;
	private int contractRoomTypeId;
	private int noOfRooms;
	private int price;
	private int roomTypeRoomTypeId;
 	private int status;

	public NpContractRoomType()
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
		String str = "INSERT INTO NP_CONTRACT_ROOM_TYPE ( " 
 		 + "CONTRACT_CONTRACT_ID, "
		 + "CONTRACT_ROOM_TYPE_ID, "
		 + "NO_OF_ROOMS, "
		 + "PRICE, "
		 + "ROOM_TYPE_ROOM_TYPE_ID )VALUES(?,?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractContractId );
		ps.setInt( ++count, this.contractRoomTypeId );
		ps.setInt( ++count, this.noOfRooms );
		ps.setInt( ++count, this.price );
		ps.setInt( ++count, this.roomTypeRoomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM NP_CONTRACT_ROOM_TYPE WHERE "
		 + "CONTRACT_ROOM_TYPE_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractRoomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE NP_CONTRACT_ROOM_TYPE SET "
		 + "CONTRACT_CONTRACT_ID = ?, "
		 + "NO_OF_ROOMS = ?, "
		 + "PRICE = ?, "
		 + "ROOM_TYPE_ROOM_TYPE_ID = ? WHERE "
		 + "CONTRACT_ROOM_TYPE_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractContractId );
		ps.setInt( ++count, this.noOfRooms );
		ps.setInt( ++count, this.price );
		ps.setInt( ++count, this.roomTypeRoomTypeId );
		ps.setInt( ++count, this.contractRoomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.contractContractId = rs.getInt( "CONTRACT_CONTRACT_ID" );
		this.contractRoomTypeId = rs.getInt( "CONTRACT_ROOM_TYPE_ID" );
		this.noOfRooms = rs.getInt( "NO_OF_ROOMS" );
		this.price = rs.getInt( "PRICE" );
		this.roomTypeRoomTypeId = rs.getInt( "ROOM_TYPE_ROOM_TYPE_ID" );


	}

	public int getContractContractId()
	{
		return this.contractContractId;
	}

	public void setContractContractId( int contractContractId )
	{
		this.contractContractId = contractContractId;
	}

	public int getContractRoomTypeId()
	{
		return this.contractRoomTypeId;
	}

	public void setContractRoomTypeId( int contractRoomTypeId )
	{
		this.contractRoomTypeId = contractRoomTypeId;
	}

	public int getNoOfRooms()
	{
		return this.noOfRooms;
	}

	public void setNoOfRooms( int noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	public int getPrice()
	{
		return this.price;
	}

	public void setPrice( int price )
	{
		this.price = price;
	}

	public int getRoomTypeRoomTypeId()
	{
		return this.roomTypeRoomTypeId;
	}

	public void setRoomTypeRoomTypeId( int roomTypeRoomTypeId )
	{
		this.roomTypeRoomTypeId = roomTypeRoomTypeId;
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
