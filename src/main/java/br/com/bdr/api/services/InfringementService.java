package br.com.bdr.api.services;

import br.com.bdr.api.enums.VehicleType;
import br.com.bdr.api.models.Infringement;
import br.com.bdr.api.repositories.InfringementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfringementService {

    @Autowired
    private InfringementRepository repo;

    public boolean register(Infringement infringement) {
        if (infringement == null) {
            return false;
        }

        if (infringement.getVehicleType() == null ||
                infringement.getVehicleType().toString().isEmpty() ||
                infringement.getVehicleType().toString().isBlank()) {
            return false;
        }

        if (!validateVehicleType(infringement.getVehicleType())) {
            return false;
        }

        repo.save(infringement);

        return true;
    }

    public boolean validateVehicleType(VehicleType type) {

        switch (type) {
            case CAR:
                return true;
            case BUS:
                return true;
            case MOTORBIKE:
                return true;
            case VAN:
                return true;
            case TRUCK:
                return true;
            default:
                return false;
        }
    }
}
