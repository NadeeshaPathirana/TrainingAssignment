package com.travelAgency.db;

import it.codegen.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpContract", namespace = "http://db.travelAgency.com.java.main")
public class NpContract extends it.codegen.Savable
{
 	private CGTimestamp validFrom;
	private CGTimestamp validTo;
	private int markup;
	private int contractId;
	private int hotelHotelId;
 	private int status;

	public NpContract()
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
		String str = "INSERT INTO NP_CONTRACT ( " 
 		 + "VALID_FROM, "
		 + "VALID_TO, "
		 + "MARKUP, "
		 + "CONTRACT_ID, "
		 + "HOTEL_HOTEL_ID )VALUES(?,?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setTimestamp( ++count,  this.validFrom._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.validTo._getSQLTimestamp() );
		ps.setInt( ++count, this.markup );
		ps.setInt( ++count, this.contractId );
		ps.setInt( ++count, this.hotelHotelId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM NP_CONTRACT WHERE "
		 + "CONTRACT_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE NP_CONTRACT SET "
		 + "VALID_FROM = ?, "
		 + "VALID_TO = ?, "
		 + "MARKUP = ?, "
		 + "HOTEL_HOTEL_ID = ? WHERE "
		 + "CONTRACT_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setTimestamp( ++count,  this.validFrom._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.validTo._getSQLTimestamp() );
		ps.setInt( ++count, this.markup );
		ps.setInt( ++count, this.hotelHotelId );
		ps.setInt( ++count, this.contractId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.validFrom = new CGTimestamp( rs.getTimestamp( "VALID_FROM" ) );
		this.validTo = new CGTimestamp( rs.getTimestamp( "VALID_TO" ) );
		this.markup = rs.getInt( "MARKUP" );
		this.contractId = rs.getInt( "CONTRACT_ID" );
		this.hotelHotelId = rs.getInt( "HOTEL_HOTEL_ID" );


	}

	public CGTimestamp getValidFrom()
	{
		return this.validFrom;
	}

	public void setValidFrom( CGTimestamp validFrom )
	{
		this.validFrom = validFrom;
	}

	public CGTimestamp getValidTo()
	{
		return this.validTo;
	}

	public void setValidTo( CGTimestamp validTo )
	{
		this.validTo = validTo;
	}

	public int getMarkup()
	{
		return this.markup;
	}

	public void setMarkup( int markup )
	{
		this.markup = markup;
	}

	public int getContractId()
	{
		return this.contractId;
	}

	public void setContractId( int contractId )
	{
		this.contractId = contractId;
	}

	public int getHotelHotelId()
	{
		return this.hotelHotelId;
	}

	public void setHotelHotelId( int hotelHotelId )
	{
		this.hotelHotelId = hotelHotelId;
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
