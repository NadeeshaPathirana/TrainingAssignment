package com.travelAgency.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpControomtype", namespace = "http://db.travelAgency.com")
public class NpControomtype extends it.codegen.Savable
{
 	private int contractRoomTypeId;
	private int noOfRooms;
	private int price;
	private int npContractContractId;
	private int npRoomtypeRoomTypeId;
 	private int status;

	public NpControomtype()
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
		String str = "INSERT INTO NP_CONTROOMTYPE ( " 
 		 + "CONTRACT_ROOM_TYPE_ID, "
		 + "NO_OF_ROOMS, "
		 + "PRICE, "
		 + "NP_CONTRACT_CONTRACT_ID, "
		 + "NP_ROOMTYPE_ROOM_TYPE_ID )VALUES(?,?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractRoomTypeId );
		ps.setInt( ++count, this.noOfRooms );
		ps.setInt( ++count, this.price );
		ps.setInt( ++count, this.npContractContractId );
		ps.setInt( ++count, this.npRoomtypeRoomTypeId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM NP_CONTROOMTYPE WHERE "
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
		String str = "UPDATE NP_CONTROOMTYPE SET "
		 + "NO_OF_ROOMS = ?, "
		 + "PRICE = ?, "
		 + "NP_CONTRACT_CONTRACT_ID = ?, "
		 + "NP_ROOMTYPE_ROOM_TYPE_ID = ? WHERE "
		 + "CONTRACT_ROOM_TYPE_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.noOfRooms );
		ps.setInt( ++count, this.price );
		ps.setInt( ++count, this.npContractContractId );
		ps.setInt( ++count, this.npRoomtypeRoomTypeId );
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
		this.contractRoomTypeId = rs.getInt( "CONTRACT_ROOM_TYPE_ID" );
		this.noOfRooms = rs.getInt( "NO_OF_ROOMS" );
		this.price = rs.getInt( "PRICE" );
		this.npContractContractId = rs.getInt( "NP_CONTRACT_CONTRACT_ID" );
		this.npRoomtypeRoomTypeId = rs.getInt( "NP_ROOMTYPE_ROOM_TYPE_ID" );


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

	public int getNpContractContractId()
	{
		return this.npContractContractId;
	}

	public void setNpContractContractId( int npContractContractId )
	{
		this.npContractContractId = npContractContractId;
	}

	public int getNpRoomtypeRoomTypeId()
	{
		return this.npRoomtypeRoomTypeId;
	}

	public void setNpRoomtypeRoomTypeId( int npRoomtypeRoomTypeId )
	{
		this.npRoomtypeRoomTypeId = npRoomtypeRoomTypeId;
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
