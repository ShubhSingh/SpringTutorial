package tutorial10.springjdbc.annotation.mapper;

import org.springframework.jdbc.core.RowMapper;

import tutorial10.springjdbc.annotation.model.Offer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer> {

    @Override
    public Offer mapRow(ResultSet resultSet, int i) throws SQLException {
        Offer offer = new Offer();
        offer.setId(resultSet.getInt("id"));
        offer.setName(resultSet.getString("name"));
        offer.setEmail(resultSet.getString("email"));
        offer.setText(resultSet.getString("text"));
        return offer;
    }
}
