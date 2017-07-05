package tutorial10.springjdbc.annotation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tutorial10.springjdbc.annotation.mapper.OfferMapper;
import tutorial10.springjdbc.annotation.model.Offer;

@Component("offerDao")
public class OfferDAO {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Offer> getOffers() {
        return jdbcTemplate.query("Select * From TESTSCHEMA.offers", new OfferMapper());
    }

    public List<Offer> getOffersByName(String name) {

        MapSqlParameterSource params = new MapSqlParameterSource("name", name);
        return  namedParameterJdbcTemplate.query("Select * From TESTSCHEMA.offers Where name = :name",
                params, new OfferMapper());
    }

    public Offer getOfferById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(
                "Select * From TESTSCHEMA.offers Where id = :id",
                params, new OfferMapper());
    }

    public boolean deleteOffer(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return namedParameterJdbcTemplate.update(
                "Delete from TESTSCHEMA.offers Where id = :id", params) == 1;
    }

    public boolean createOffer(Offer offer) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return namedParameterJdbcTemplate.update(
            "Insert into TESTSCHEMA.offers (id, name, email, text) values (:id, :name, :email, :text)", params) == 1;
    }

    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return namedParameterJdbcTemplate.update(
                "Update TESTSCHEMA.offers set name = :name, text = :text, email = :email Where id = :id",
                params) == 1;
    }

    public int[] create(List<Offer> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return namedParameterJdbcTemplate.batchUpdate(
                "Insert into TESTSCHEMA.offers (id, name, email, text) values (:id, :name, :email, :text)",
                params);
    }

    @Transactional
    public int[] createForTx(List<Offer> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return namedParameterJdbcTemplate.batchUpdate(
                "Insert into TESTSCHEMA.offers (id, name, email, text) values (:id, :name, :email, :text)",
                params);
    }
}
