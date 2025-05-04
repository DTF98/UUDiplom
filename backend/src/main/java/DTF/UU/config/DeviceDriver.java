package DTF.UU.config;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DeviceDriver {

    private final DeviceProperties props;

    private SerialPort port;

    public DeviceDriver(DeviceProperties props) {
        this.props = props;
    }

//    @PostConstruct
//    public void init() {
//        port = SerialPort.getCommPort(props.getPort());
//        port.setComPortParameters(props.getBaudRate(), 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
//        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 1000);
//        if (port.openPort()) {
//            System.out.println("✅ Устройство подключено на " + props.getPort());
//        } else {
//            throw new IllegalStateException("❌ Не удалось открыть порт " + props.getPort());
//        }
//    }
//
//    @PreDestroy
//    public void cleanup() {
//        if (port != null && port.isOpen()) {
//            port.closePort();
//            System.out.println("🔌 Соединение с устройством закрыто");
//        }
//    }
//
//    public SerialPort getPort() {
//        return port;
//    }
}
