package com.travelAgency.db;

import it.codegen.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "NpContract", namespace = "http://db.travelAgency.com")
public class NpContract extends it.codegen.Savable
{
 	private int contractId;
	private CGTimestamp validFrom;
	private CGTimestamp validTo;
	private int npHotelHotelId;
	private int markup;
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
 		 + "CONTRACT_ID, "
		 + "VALID_FROM, "
		 + "VALID_TO, "
		 + "NP_HOTEL_HOTEL_ID, "
		 + "MARKUP )VALUES(?,?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractId );
		ps.setTimestamp( ++count,  this.validFrom._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.validTo._getSQLTimestamp() );
		ps.setInt( ++count, this.npHotelHotelId );
		ps.setInt( ++count, this.markup );
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
		 + "NP_HOTEL_HOTEL_ID = ?, "
		 + "MARKUP = ? WHERE "
		 + "CONTRACT_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setTimestamp( ++count,  this.validFrom._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.validTo._getSQLTimestamp() );
		ps.setInt( ++count, this.npHotelHotelId );
		ps.setInt( ++count, this.markup );
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
		this.contractId = rs.getInt( "CONTRACT_ID" );
		this.validFrom = new CGTimestamp( rs.getTimestamp( "VALID_FROM" ) );
		this.validTo = new CGTimestamp( rs.getTimestamp( "VALID_TO" ) );
		this.npHotelHotelId = rs.getInt( "NP_HOTEL_HOTEL_ID" );
		this.markup = rs.getInt( "MARKUP" );


	}

	public int getContractId()
	{
		return this.contractId;
	}

	public void setContractId( int contractId )
	{
		this.contractId = contractId;
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

	public int getNpHotelHotelId()
	{
		return this.npHotelHotelId;
	}

	public void setNpHotelHotelId( int npHotelHotelId )
	{
		this.npHotelHotelId = npHotelHotelId;
	}

	public int getMarkup()
	{
		return this.markup;
	}

	public void setMarkup( int markup )
	{
		this.markup = markup;
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
