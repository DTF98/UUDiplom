package DTF.UU.service;

import DTF.UU.config.DeviceDriver;
import DTF.UU.dto.CurrentAndVoltage;
import DTF.UU.model.ValuePoint;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class UUService {

    private final DeviceDriver deviceDriver;

    public UUService(DeviceDriver deviceDriver) {
        this.deviceDriver = deviceDriver;
    }

//    private Boolean state = false;
//
//    public Boolean changeDeviceState() {
//        SerialPort port = deviceDriver.getPort();
//        OutputStream out = port.getOutputStream();
//        String command;
//        if (state) {
//            command = "1";
//            state = false;
//        } else {
//            command = "0";
//            state = true;
//        }
//        try {
//            out.write(command.getBytes());
//            out.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return state;
//    }
//
//    public CurrentAndVoltage getCurrentAndVoltage(Integer load) {
//        SerialPort port = deviceDriver.getPort();
//        OutputStream out = port.getOutputStream();
//        String command;
//        try {
//            switch (load) {
//                case 24 -> {
//                    command = "2";
//                    out.write(command.getBytes());
//                    out.flush();
//                    Thread.sleep(200); // небольшая задержка, чтобы STM32 успел ответить
//                }
//                case 12 -> {
//                    command = "3";
//                    out.write(command.getBytes());
//                    out.flush();
//                    Thread.sleep(200); // небольшая задержка, чтобы STM32 успел ответить
//                }
//                case 8 -> {
//                    command = "4";
//                    out.write(command.getBytes());
//                    out.flush();
//                    Thread.sleep(200); // небольшая задержка, чтобы STM32 успел ответить
//                }
//                case 6 -> {
//                    command = "5";
//                    out.write(command.getBytes());
//                    out.flush();
//                    Thread.sleep(200); // небольшая задержка, чтобы STM32 успел ответить
//                }
//            }
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException("Ошибка подключения нагрузки");
//        }
//        List<ValuePoint> current = getCurrent();
//        List<ValuePoint> voltage = getVoltage();
//
//        return new CurrentAndVoltage(current, voltage);
//    }
//
//    private List<ValuePoint> getCurrent() {
//        SerialPort port = deviceDriver.getPort();
//        InputStream in = port.getInputStream();
//        OutputStream out = port.getOutputStream();
//        String command;
//        List<ValuePoint> current = new ArrayList<>();
//        try {
//            command = "7";
//            out.write(command.getBytes());
//            out.flush();
//
//            Thread.sleep(1000); // небольшая задержка, чтобы STM32 успел ответить
//
//            int available = in.available();
//            if (available > 0) {
//                Instant time = Instant.now();
//                byte[] buffer = new byte[available];
//                in.read(buffer, 0, available);
//                String response = new String(buffer);
//                System.out.println("Ответ:\n" + response);
//                String[] arr = response.split(",");
//                for (int i = 1; i < 10; i++) {
//                    current.add(new ValuePoint(time.plusMillis(10 * i), Double.valueOf(arr[i])));
//                }
//            } else {
//                System.out.println("Нет данных от контроллера.");
//            }
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException("Ошибка поолучения тока");
//        }
//
//        return current;
//    }
//
//    private List<ValuePoint> getVoltage() {
//        SerialPort port = deviceDriver.getPort();
//        InputStream in = port.getInputStream();
//        OutputStream out = port.getOutputStream();
//        String command;
//        List<ValuePoint> voltage = new ArrayList<>();
//        try {
//            command = "8";
//            out.write(command.getBytes());
//            out.flush();
//
//            Thread.sleep(1000); // небольшая задержка, чтобы STM32 успел ответить
//
//            int available = in.available();
//            if (available > 0) {
//                Instant time = Instant.now();
//                byte[] buffer = new byte[available];
//                in.read(buffer, 0, available);
//                String response = new String(buffer);
//                System.out.println("Ответ:\n" + response);
//                String[] arr = response.split(",");
//                for (int i = 1; i < 10; i++) {
//                    voltage.add(new ValuePoint(time.plusMillis(10 * i), Double.valueOf(arr[i])));
//                }
//            } else {
//                System.out.println("Нет данных от контроллера.");
//            }
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException("Ошибка получения напряжения");
//        }
//
//        return voltage;
//    }
}
