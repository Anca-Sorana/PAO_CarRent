package pao.mapper;
import pao.model.Car;
import pao.model.Reservation;
import pao.model.enums.Car_Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public class ReservationMapper {
    private static final ReservationMapper INSTANCE = new ReservationMapper();

    private ReservationMapper() {
    }

    public static ReservationMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Reservation> mapToReservation(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .price(resultSet.getInt(2))
//                            .car(UUID.fromString(resultSet.getString(3)))
                            .startDate(resultSet.getDate(4).toLocalDate())
                            .endDate(resultSet.getDate(5).toLocalDate())
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Reservation> mapToReservationList(ResultSet resultSet) throws SQLException {
        List<Reservation> ReservationList = new ArrayList<>();
        while (resultSet.next()) {
            ReservationList.add(
                    Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .price(resultSet.getInt(2))
//                            .car(UUID.fromString(resultSet.getString(3)))
                            .startDate(resultSet.getDate(4).toLocalDate())
                            .endDate(resultSet.getDate(5).toLocalDate())
                            .build()
            );
        }

        return ReservationList;
    }
}
