import com.easyrentals.service.EasyRentalsService;
import com.easyrentals.service.impl.EasyRentalsServiceImpl;

module EasyRentalsServiceImpl {
    requires EasyRentalsService;
    requires EasyRentalsDao;
    requires EasyRentalsModel;
    exports com.easyrentals.service.impl;
    provides EasyRentalsService with EasyRentalsServiceImpl;
}