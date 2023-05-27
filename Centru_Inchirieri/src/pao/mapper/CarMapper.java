package pao.mapper;

import pao.model.Car;
import pao.model.enums.Car_Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarMapper {
    private static final CarMapper INSTANCE = new CarMapper();

    private CarMapper() {
    }

    public static CarMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Car> mapToCar(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Car.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .type(Car_Type.valueOf(resultSet.getString(2)))
                            .color(resultSet.getString(3))
                            .year(resultSet.getInt(4))
                            .seatsNumber(resultSet.getInt(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Car> mapToCarList(ResultSet resultSet) throws SQLException {
        List<Car> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Car.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .type(Car_Type.valueOf(resultSet.getString(2)))
                            .color(resultSet.getString(3))
                            .year(resultSet.getInt(4))
                            .seatsNumber(resultSet.getInt(5))
                            .build()
            );
        }

        return exampleClassList;
    }
}
