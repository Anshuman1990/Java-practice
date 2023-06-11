import com.easyrentals.service.EasyRentalsService;
import com.easyrentals.service.impl.EasyRentalsServiceImpl;

module EasyRentalsServiceImpl {
    requires EasyRentalsService;
    requires EasyRentalsDao;
    requires EasyRentalsModel;
    provides EasyRentalsService with EasyRentalsServiceImpl;
}