package javalistener;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 * Структура для хранения четырех переменных.
 * @author servb
 */
class xyzt {
    
    public int x, y, z, t;

    public xyzt(int x, int y, int z, int t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }
    
}

/**
 *
 * @author SerVB
 */
public class JavaListenerCode {
    ArrayList<String> alCurLocale = new ArrayList();    // Массив с текущим переводом

    // Объекты формы:
    public JPanel uiPanelCOM,
            uiPanelSector,
            uiPanelSets,
            uiPanelLang,
            uiPanelRound,
            uiPanelOtherSets,
            uiPanelParking,
            uiPanelButton,
            uiPanelStatus,
            uiPanelStop;

    public JButton uiButtonApplyCOM,
            uiButtonScanningBegin,
            uiButtonLangRus,
            uiButtonRound,
            uiButtonLangEng,
            uiButtonPark,
            uiButtonStopScan;

    public JLabel uiLabelCOM,
            uiLabelBaudrate,
            uiLabelBaud,
            uiLabelNumOfRep,
            uiLabelMovingType,
            uiLabelDelay,
            uiLabelMs,
            uiLabelInterface,
            uiLabelParkAlt,
            uiLabelParkDeg,
            uiLabelHor,
            uiLabelHorStep,
            uiLabelVer,
            uiLabelVerLine,
            uiLabelVerUnit,
            uiLabelVerAcUnit,
            uiLabelVerStep,
            uiLabelTaskHor,
            uiLabelTaskHorLine,
            uiLabelTaskHorStep,
            uiLabelTaskVer,
            uiLabelTaskVerLine,
            uiLabelTaskVerStep,
            uiLabelCondition,
            uiLabelRepeatition,
            uiLabelRepOf,
            uiLabelMeasure,
            uiLabelMeasOf,
            uiLabelSecLittle,
            uiLabelPercentBigTitle,
            uiLabelPercentLittleTitle,
            uiLabelSecBig,
            uiLabelCurScanLose;

    public JLabel       uiLabelStatus,          // Статус

                        uiLabelCurRep,          // Номер текущего повтора
                        uiLabelTotalRep,        // Количество повторов в текущей задаче

                        uiLabelCurMeas,         // Номер текущего измерения
                        uiLabelTotalMeas,       // Количество измерений в текущем повторе

                        uiLabelPercentLittle,   // Процент выполнения текущего повтора
                        uiLabelPercentBig,      // Процент выполнения текущей задачи

                        uiLabelTaskHorBegin,    // Начальная координата азимута
                        uiLabelTaskHorEnd,      // Конечная координата азимута
                        uiLabelTaskHorAc,       // Шаг азимута
                        uiLabelTaskVerBegin,    // Начальная кордината высоты
                        uiLabelTaskVerEnd,      // Конечная координата высоты
                        uiLabelTaskVerAc,       // Шаг высоты

                        uiLabelTaskHorUnit,     // Единицы измерения координат азимута
                        uiLabelTaskHorAcUnit,   // Единицы измерения шага азимута
                        uiLabelTaskVerUnit,     // Единицы измерения координат высоты
                        uiLabelTaskVerAcUnit,   // Единицы измерения шага высоты

                        uiLabelSBig,            // Остаток секунд до выполнения текущего повтора
                        uiLabelSLittle;         // Остаток секунд до выполнения текущей задачи

    public JTextField   uiTextBaudrate,         // Скорость работы COM порта
                        uiTextCOM,              // Номер COM порта

                        uiTextHorBegin,         // Заданная начальная координата азимута
                        uiTextHorEnd,           // Заданная конечная координата азимута
                        uiTextHorAc,            // Заданный шаг азимута
                        uiTextVerBegin,         // Заданная начальная координата высоты
                        uiTextVerEnd,           // Заданная конечная координата высоты
                        uiTextVerAc,            // Заданный шаг высоты

                        uiTextNumOfRep,         // Заданное количество повторов

                        uiTextDelayBeforeMeasure,   // Заданная задержка перед каждым измерением

                        uiTextParkAlt;              // Высота парковки

    public JComboBox    uiComboHorAcUnit,           // Заданная единица измерения шага азимута
                        uiComboHorUnit,             // Заданная единица измерения координат азимута
                        uiComboMovingType,          // Заданная единица измерения шага высоты
                        uiComboSensorType;          // Заданная единица измерения координат высоты

    public JProgressBar uiProgressLittle,           // Шкала выполнения текущего повтора
                        uiProgressBig;              // Шкала выполнения всей текущей задачи

    public JCheckBox    uiCheckCompareMode;         // Включение режима сравнения
    // Конец объектов формы.

    public SerialPort serialPort = new SerialPort(null);    // Объект последовательного порта

    private boolean isReady = false;    // Готовность устройства принимать запрос на сканирование
    private String logData = "";        // Содержимое лога (содержимое результирующего файла)
    private String currentString = "";  // Считанная с порта строка
    private String bufferString = "";   // Буферная строка для хранения считанной с порта информации после энтера
    private int curRep,     // Номер текущего повтора
                numOfRep;   // Количество повторов во всей задаче
    private int horRange;   // Количество шагов шаговика от начальной до конечной координаты азимута по модулю
    private int verRange;   // Количество градусов от начальной до конечной координаты высоты по модулю
    private int curMeas,    // Номер текущего измерения
                numOfMeas;  // Количество измерений
    private String timeBegin;   // Строка с датой и временем отправки текущей задачи
    private long msBig; // Начало выполнения задачи

    private int horRealBegin,horRealEnd,horRealAc; // Координаты, по которым будет двигаться устройство
    private int verRealBegin,verRealEnd,verRealAc; // как оно считало с порта

    private Map mapHor,mapVer;  // Карта соответствий координаты на сфере и пикселя на проекции
    private ImageWindow curIW;  // Текущее окно с картинкой
    private int horMin,horMax;  // Минимальная и максимальная координата по азимуту
    private int verMin,verMax;  // Минимальная и максимальная координата по высоте
    private int numOfHor,numOfVer;  // Количество пикселей по азимуту и по высоте на проекции

    private double stepDivDeg = 400./360.;  // Количество шагов шаговика в одном градусе

    private double tempFrom = -50.0; // Температура черного цвета по умолчанию
    private double tempTo   =  50.0; // Температура белого цвета по умолчанию (должно быть больше tempFrom)
    
    private int maxAnalogValue = 1023; // Максимальное значение аналогового датчика
    
    private int sensorType = 0; // Тип сенсора

    ArrayList<xyzt> alMap = new ArrayList(); // Структура для хранения карты глубины
//    ArrayList<Long> alTimeBig = new ArrayList(); // Для всей текущей задачи
    ArrayList<Long> alTimeLittle = new ArrayList(); // Для текущего повтора
    private long timeLittleLastUpdate; // Для текущего повтора

    BufferedImage lastImage = new BufferedImage(1, 1, BufferedImage.TYPE_USHORT_GRAY); // Прошлая картинка для режима сравнения

    boolean haveLastImage = false; // Имеется ли прошлая картинка

    public void changeLang(int lang) throws FileNotFoundException, IOException { // Сменить язык
        alCurLocale.clear(); // Очистка текущего хранилища перевода
        String pathToLangFile; // Путь к языковому файлу
        switch(lang) { // Выбор языка
            case 0:
                pathToLangFile = "rus.txt";
                break;
            case 1:
                pathToLangFile = "eng.txt";
                break;
            default:
                System.err.println("No lang file for language #" + lang + "!");
                System.err.println("Set lang to english!");
                pathToLangFile = "eng.txt";
                break;
        }
        File f = new File(pathToLangFile); // Файл языка
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8")); // Чтец файла
        String tmp; // Считанная из файла строка
        while((tmp = br.readLine()) != null) { // Пока считанная строка не пустая
            alCurLocale.add(tmp); // Добавить в хранилище перевода считанную строку
        }

        changeLangSwing(); // Обновить надписи в графическом интерфейсе
    }

    private void changeLangSwing() { // Обновить надписи в графическом интерфейсе
        uiPanelCOM.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(0))); // Настройки порта:
        uiLabelCOM.setText(alCurLocale.get(1)); // COM
        uiLabelBaudrate.setText(alCurLocale.get(2)); // , скорость
        uiLabelBaud.setText(alCurLocale.get(3)); // бод
        uiButtonApplyCOM.setText(alCurLocale.get(4)); // Применить настройки порта
        uiPanelSets.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(5))); // Параметры сканирования:
        uiLabelHor.setText(alCurLocale.get(6)); // Азимут
        uiLabelTaskHor.setText(alCurLocale.get(6)); // Азимут

        int sel = uiComboHorAcUnit.getSelectedIndex();
        uiComboHorAcUnit.removeAllItems();
        uiComboHorAcUnit.addItem(alCurLocale.get(7)); // (градусы)
        uiComboHorAcUnit.addItem(alCurLocale.get(8)); // (шаги)
        uiComboHorAcUnit.setSelectedIndex(sel);

        sel = uiComboHorUnit.getSelectedIndex();
        uiComboHorUnit.removeAllItems();
        uiComboHorUnit.addItem(alCurLocale.get(7)); // (градусы)
        uiComboHorUnit.addItem(alCurLocale.get(8)); // (шаги)
        uiComboHorUnit.setSelectedIndex(sel);

        uiLabelHorStep.setText(alCurLocale.get(9)); // с шагом
        uiLabelVerStep.setText(alCurLocale.get(9)); // с шагом
        uiLabelTaskHorStep.setText(alCurLocale.get(9)); // с шагом
        uiLabelTaskVerStep.setText(alCurLocale.get(9)); // с шагом
        uiLabelVer.setText(alCurLocale.get(10)); // Высота
        uiLabelTaskVer.setText(alCurLocale.get(10)); // Высота
        uiLabelParkAlt.setText(alCurLocale.get(10)); // Высота
        uiLabelVerAcUnit.setText(alCurLocale.get(11)); //  (градусы)
        uiLabelVerUnit.setText(alCurLocale.get(11)); //  (градусы)
        uiLabelParkDeg.setText(alCurLocale.get(11)); //  (градусы)
        uiPanelRound.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(12)));
        uiButtonRound.setText(alCurLocale.get(14));
        uiPanelOtherSets.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(15)));
        uiLabelNumOfRep.setText(alCurLocale.get(16)); // Количество повторов:
        uiLabelMovingType.setText(alCurLocale.get(17)); // Тип движения:

        sel = uiComboMovingType.getSelectedIndex();
        uiComboMovingType.removeAllItems();
        uiComboMovingType.addItem(alCurLocale.get(18)); // по высоте, грубо
        uiComboMovingType.addItem(alCurLocale.get(19)); // по азимуту, грубо
        uiComboMovingType.addItem(alCurLocale.get(20)); // по высоте, медленно
        uiComboMovingType.addItem(alCurLocale.get(21)); // по азимуту, медленно
        uiComboMovingType.setSelectedIndex(sel);

        uiLabelDelay.setText(alCurLocale.get(22)); // Задержка перед измерением:
        uiLabelMs.setText(alCurLocale.get(23)); // мс
        uiLabelInterface.setText(alCurLocale.get(24)); // Интерфейс подключения датчика:

        sel = uiComboSensorType.getSelectedIndex();
        uiComboSensorType.removeAllItems();
        uiComboSensorType.addItem(alCurLocale.get(25)); // А0,  сред. за 20 мс
        uiComboSensorType.addItem(alCurLocale.get(26)); // I2C, сред. за 20 мс
        uiComboSensorType.addItem(alCurLocale.get(27)); // I2C, одно измерение
        uiComboSensorType.setSelectedIndex(sel);

        uiCheckCompareMode.setText(alCurLocale.get(28)); // Режим сравнения
//        alCurLocale.get(0); // Сохранение картинки на диск
        uiButtonScanningBegin.setText(alCurLocale.get(30)); // Начать сканирование
        uiPanelStatus.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(31))); // Статус сканирования:
        uiLabelCondition.setText(alCurLocale.get(32)); // Состояние установки:
//        alCurLocale.get(0); // Н/Д
        uiLabelRepeatition.setText(alCurLocale.get(34)); // Повтор
        uiLabelRepOf.setText(alCurLocale.get(35)); // из
        uiLabelMeasOf.setText(alCurLocale.get(35)); // из
        uiLabelMeasure.setText(alCurLocale.get(36)); // , измерение
        uiLabelPercentLittleTitle.setText(alCurLocale.get(37)); // текущего повтора, осталось примерно
        uiLabelSecLittle.setText(alCurLocale.get(38)); // с
        uiLabelSecBig.setText(alCurLocale.get(38)); // с
        uiLabelPercentBigTitle.setText(alCurLocale.get(39)); // всей задачи, осталось примерно

        uiPanelParking.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(40)));
        uiButtonPark.setText(alCurLocale.get(41));
        uiPanelStop.setBorder(BorderFactory.createTitledBorder(alCurLocale.get(44)));
        uiButtonStopScan.setText(alCurLocale.get(44));
        uiLabelCurScanLose.setText(alCurLocale.get(43));
    }

    public void newSerial() throws SerialPortException { // Создать последовательный порт
        isReady = true;
        
        final String COM = uiTextCOM.getText(); // Номер последовательного порта
        final int BAUD = Integer.parseInt(uiTextBaudrate.getText()); // Скорость работы последовательного порта

        if(serialPort.isOpened()) // Если последовательный порт открыт
            serialPort.closePort(); // Закрыть последовательный порт
        serialPort = new SerialPort("COM" + COM); // Задать номер последовательного порта
        serialPort.openPort(); // Открыть последовательный порт
        serialPort.setParams(BAUD,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE); // Установить параметры последовательного порта
        serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR); // Создать слушатель последовательного порта
    }

    public void goPark() throws SerialPortException { // Отправить запрос на парковку
        if(!isReady) { // Если микроконтроллер не готов
            System.err.println("Can't send \"goPark\": arduino isn't ready!"); // Вывод сообщения об ошибке
            return; // Завершить без отправки
        }
        final int HEIGHT = Integer.parseInt(uiTextParkAlt.getText());
        sendRequest(new int[] {HEIGHT,HEIGHT,HEIGHT,HEIGHT,HEIGHT,HEIGHT,
                               HEIGHT,HEIGHT,4,4,4,4
        });
        System.out.println(Arrays.toString(new int[] {HEIGHT,HEIGHT,HEIGHT,HEIGHT,HEIGHT,HEIGHT,
            HEIGHT,HEIGHT,4,4,4,4
        }));
    }

    public void goScan() throws SerialPortException, IOException { // Отправить запрос сканирования на микроконтроллер
        if(!isReady) { // Если микроконтроллер не готов
            System.err.println("Can't send \"goScan\": arduino isn't ready!"); // Вывод сообщения об ошибке
            return; // Завершить без отправки
        }

        roundTask(); // Округлить заданный сектор сканирования

        final int HOR_BEGIN = Integer.parseInt(uiLabelTaskHorBegin.getText());
        final int HOR_END   = Integer.parseInt(uiLabelTaskHorEnd  .getText());
        final int HOR_AC    = Integer.parseInt(uiLabelTaskHorAc   .getText());
        final boolean HOR_UNIT_DEG      = false;
        final boolean HOR_AC_UNIT_DEG   = false;

        final int VER_BEGIN = Integer.parseInt(uiLabelTaskVerBegin.getText());
        final int VER_END   = Integer.parseInt(uiLabelTaskVerEnd  .getText());
        final int VER_AC    = Integer.parseInt(uiLabelTaskVerAc   .getText());

        final int NUM_OF_REP = Integer.parseInt(uiTextNumOfRep.getText());
        final int MOVING_TYPE = uiComboMovingType.getSelectedIndex();

        final int DELAY = Integer.parseInt(uiTextDelayBeforeMeasure.getText());
        final int SENSOR_TYPE = uiComboSensorType.getSelectedIndex();

        /* Отправить запрос на ардуино с параметра: */
        sendRequest(new int[] {        HOR_BEGIN, HOR_END, HOR_AC,
                                       (HOR_UNIT_DEG?1:0), (HOR_AC_UNIT_DEG?1:0),
                                       VER_BEGIN, VER_END, VER_AC,
                                       NUM_OF_REP, MOVING_TYPE,
                                       DELAY, SENSOR_TYPE});
        
        sensorType = SENSOR_TYPE; // Обновить тип сенсора

        timeBegin = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(Calendar.getInstance().getTime()); // Сохранить время начала
        
        // Чтобы не ожидать надписей "повтор первый" и "измерение первое",
        // вывести в соответствующие поля единицы (не дожидаясь, пока установка
        // переместится в координаты начала сканирования):
        uiLabelCurMeas.setText("1"); // Пометить текущее измерение как первое
        uiLabelCurRep.setText("1"); // Пометить текущий повтор как первый

        saveSettings(); // Сохранить настройки
    }

    private void sendRequest(int[] data) throws SerialPortException { // Послать запрос на сканирование
        String request = String.format( // Строка для отправки на микроконтроллер
                "%d %d  %d %d  %d %d  %d %d  %d %d  %d %d\n", 
                data[0],data[1],data[2],data[3],data[4],data[5],
                data[6],data[7],data[8],data[9],data[10],data[11]
        );
        request = request.replaceAll(",", "."); // Разделитель дробной части может быть запятой (если в Windows выставлен
                                                // русский язык), поэтому заменить все запятые в строке на точки
        System.out.println(request);
        serialPort.writeString(request); // Отправить строку из 14 чисел с данными о сканировании
        isReady = false; // Определить статус микроконтроллера как "не готов"
        logData = ""; // Обнулить лог
    }

    private class PortReader implements SerialPortEventListener { // Слушатель последовательного порта
        @Override
        public void serialEvent(SerialPortEvent event) { // Событие последовательного порта
            if(event.isRXCHAR() && event.getEventValue() > 0){ // Если событие подходящее
                try {
                    String received = serialPort.readString(event.getEventValue()); // Полученная с последовательного порта строка
                    System.out.println("Received string is \"" + received + "\""); // Вывод полученной строки в консоль
                    currentString += received; // Прибавить к текущей считанной строке полученную с последовательного порта строку

                    if(currentString.contains(";")) { // Если получившаяся строка содержит символ ';' (я определил его как конец любой команды)
                        currentString = currentString.replace("\r\n", "").replace("\n", "");    // Замена всех переносов
                        bufferString  = currentString.substring(currentString.indexOf(";")+1);  // Сохранение конца строки после ';', не включая этот знак
                        currentString = currentString.substring(0, currentString.indexOf(";")); // Обрезка полученной строки до одной команды для корректной обработки
                        System.out.println("Command to be done is \"" + currentString + "\"");
                             if(currentString.contains("===m===")) // Measure - измерение
                            evtMeasure(currentString);
                        else if(currentString.contains("===r===")) // Ready - готов
                            evtReady();
                        else if(currentString.contains("===p===")) // rePeatition - повтор x из y
                            evtRepeatition(currentString);
                        else if(currentString.contains("===s===")) // Scanned request - запрос, который распознал мк
                            evtScanned(currentString);
                        else if(currentString.contains("===v===")) // moVing - как будет двигаться мк
                            evtMoving(currentString);
                        else if(currentString.contains("===e===")) // End of one of measurements - конец какого-то замера
                            evtEnd(currentString);
                        else if(currentString.contains("=park=")) // end of PARKing - завершение парковки
                            evtPark();

                        currentString = bufferString; // Записать возможный остаток в текущую строку
                        bufferString = ""; // Обнулить возможный остаток
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JavaListenerCode.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SerialPortException ex) {
                    Logger.getLogger(JavaListenerCode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    void restoreSettings() throws FileNotFoundException, IOException { // Чтение входных данных из файла
        File f = new File(new File("").getAbsolutePath() + File.separator + "options.txt"); // Файл с настройками
        final int LAST_SYMBOL; // Длина имени параметра (левая часть, включая '=')
        BufferedReader br = new BufferedReader(new FileReader(f)); // Чтец файла
        String currentLine; // Инициализация текущей строки

        currentLine = br.readLine(); // Чтение первой строки, в этой строке должно быть значение LAST_SYMBOL
        LAST_SYMBOL = Integer.parseInt(currentLine); // Записать длину имени параметра

        int i; // Индекс последней буквы в имени параметра
        while((currentLine = br.readLine()) != null) { // Строка вида "*********=........"
            if(currentLine.length()>LAST_SYMBOL && currentLine.charAt(LAST_SYMBOL-1) == '=') { // Длина строки достаточна для содержания параметра? Есть ли знак равенства на нужном месте?
                i = (currentLine.indexOf(' ') < 0 || currentLine.indexOf(' ')>LAST_SYMBOL-1) ? LAST_SYMBOL-1 : currentLine.indexOf(' '); // Позиция последнего символа имени параметра
                // Нахождение имени параметра:
                if     (currentLine.substring(0, i).equals("com"))
                    uiTextCOM.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("baudrate"))
                    uiTextBaudrate.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("horB"))
                    uiTextHorBegin.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("horE"))
                    uiTextHorEnd.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("horA"))
                    uiTextHorAc.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("horUnit"))
                    uiComboHorUnit.setSelectedIndex(Integer.parseInt(currentLine.substring(LAST_SYMBOL,currentLine.length())));
                else if(currentLine.substring(0, i).equals("horAUnit"))
                    uiComboHorAcUnit.setSelectedIndex(Integer.parseInt(currentLine.substring(LAST_SYMBOL,currentLine.length())));
                else if(currentLine.substring(0, i).equals("verB"))
                    uiTextVerBegin.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("verE"))
                    uiTextVerEnd.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("verA"))
                    uiTextVerAc.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("numOfRep"))
                    uiTextNumOfRep.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("type"))
                    uiComboMovingType.setSelectedIndex(Integer.parseInt(currentLine.substring(LAST_SYMBOL,currentLine.length())));
                else if(currentLine.substring(0, i).equals("stepDivDeg"))
                    stepDivDeg = Double.parseDouble(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("sensorType"))
                    uiComboSensorType.setSelectedIndex(Integer.parseInt(currentLine.substring(LAST_SYMBOL,currentLine.length())));
                else if(currentLine.substring(0, i).equals("waitMeasur"))
                    uiTextDelayBeforeMeasure.setText(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("tempFrom"))
                    tempFrom = Double.parseDouble(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("tempTo"))
                    tempTo = Double.parseDouble(currentLine.substring(LAST_SYMBOL,currentLine.length()));
                else if(currentLine.substring(0, i).equals("maxAnalog"))
                    maxAnalogValue = Integer.parseInt(currentLine.substring(LAST_SYMBOL,currentLine.length()));
            }
        }
    }

    void saveSettings() throws IOException { // Сохранить настройки
        final int LAST_SYMBOL = 11; // Длина имени параметра (левая часть, включая символ '=')
        final String NEW_LINE = System.getProperty("line.separator"); // Символ переноса строки в текущей системе
        String sets =   LAST_SYMBOL + NEW_LINE + // Состав файла с настройками
                        "com       =" + uiTextCOM.getText()                     + NEW_LINE +
                        "baudrate  =" + uiTextBaudrate.getText()                + NEW_LINE +
                        "horB      =" + uiTextHorBegin.getText()                + NEW_LINE +
                        "horE      =" + uiTextHorEnd.getText()                  + NEW_LINE +
                        "horA      =" + uiTextHorAc.getText()                   + NEW_LINE +
                        "horUnit   =" + uiComboHorUnit.getSelectedIndex()       + NEW_LINE +
                        "horAUnit  =" + uiComboHorAcUnit.getSelectedIndex()     + NEW_LINE +
                        "verB      =" + uiTextVerBegin.getText()                + NEW_LINE +
                        "verE      =" + uiTextVerEnd.getText()                  + NEW_LINE +
                        "verA      =" + uiTextVerAc.getText()                   + NEW_LINE +
                        "numOfRep  =" + uiTextNumOfRep.getText()                + NEW_LINE +
                        "type      =" + uiComboMovingType.getSelectedIndex()    + NEW_LINE +
                        "waitMeasur=" + uiTextDelayBeforeMeasure.getText()      + NEW_LINE +
                        "sensorType=" + uiComboSensorType.getSelectedIndex()    + NEW_LINE +
                        "tempFrom  =" + tempFrom                                + NEW_LINE +
                        "tempTo    =" + tempTo                                  + NEW_LINE +
                        "stepDivDeg=" + stepDivDeg                              + NEW_LINE +
                        "maxAnalog =" + maxAnalogValue                          + NEW_LINE;
        File f = new File(new File("").getAbsolutePath() + File.separator + "options.txt"); // Файл настроек
        if(f.exists()) f.delete(); // Если файл существует - удалить
        f.createNewFile(); // Создать файл
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8")); // Писатель файла
        bufferedWriter.append(sets); // Добавить в файл состав файла
        bufferedWriter.flush(); // Записать файл

    }
    
    int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    void evtMeasure(String s) { // Обрабатывает измерение
        // Строка вида
        // "===m=== Measure #(curMeas) of (numOfMeas): (hor) steps, (ver) degs= (measA) (measI), time: (millis);"
        //                   0            1            2            3           4       5              6
        curMeas++; // Увеличить кол-во измерений
        uiLabelCurMeas.setText(curMeas + ""); // Вывести номер текущего измерения в форму
        vStringToArrayOfInt(s); // Разбить строку измерений на массив int
        if (ardStringToArrayOfIntSize >= 7) { // Если верная строка
            int horCord = ardStringToArrayOfInt[2]; // Гор. координата
            int verCord = ardStringToArrayOfInt[3]; // Вер. кооддината
            int valueAnalog = ardStringToArrayOfInt[4]; // Значение аналога
            int valueIr = ardStringToArrayOfInt[5]; // Значение ИК
            logData += horCord + " " + verCord + " " + valueAnalog + " " + valueIr + System.getProperty("line.separator"); // Запись в лог
            alMap.add(new xyzt(horCord,verCord,valueAnalog,valueIr)); // Добавление точки измерения в хранилище всех точек измерения
            if (sensorType == 0) { // Если был выбран аналог
                int pixel = map(valueAnalog, 0, maxAnalogValue, 0, (2 << 16) - 1); // Получить цвет пикселя
                updatePic(horCord,verCord,pixel); // Обновить картинку на экране: добавить точку
            } else { // Иначе был выбран ИК
                int pixel = map(valueIr, (int) Math.round(tempFrom * 100), (int) Math.round(tempTo * 100), 0, (2 << 16) - 1); // Получить цвет пикселя
                updatePic(horCord,verCord,pixel); // Обновить картинку на экране: добавить точку
            }

            uiLabelStatus.setText(alCurLocale.get(45)); // Обновить статус на "Сканирование в процессе"

            // Вычисление процента выполнения текущей картинки и вывод процента в форму:
            double percentLittle = 100.0 * curMeas / numOfMeas; 
            uiLabelPercentLittle.setText(String.format("%.2f", percentLittle) + "%");
            uiProgressLittle.setValue((int) Math.round(percentLittle * 100));

            // Вычисление процента выполнения всей задачи и вывод процента в форму:
            double percentBig = 100.0 * (curMeas + (curRep-1) * numOfMeas) / (numOfRep * numOfMeas);
            uiLabelPercentBig.setText(String.format("%.2f", percentBig) + "%");
            uiProgressBig.setValue((int) Math.round(percentBig * 100));

            // Вычисление оставшегося времени выполнения текущей кортинки
            // Лютая магия, притом не работающая верно (уменьшает время)
            alTimeLittle.add(System.currentTimeMillis());
            final int NUM_OF_SEC = 1;

            if(alTimeLittle.get(alTimeLittle.size()-1) - timeLittleLastUpdate > 500 && alTimeLittle.size() > NUM_OF_SEC) {
                timeLittleLastUpdate += 500;

                long passedTime = 0;
                int i;
                for(i = 1; i < alTimeLittle.size(); i++) {
                    passedTime += alTimeLittle.get(i) - alTimeLittle.get(0);
                }
                passedTime /= (i-1);
                final int measRemain = numOfMeas-curMeas;
                final int remS = new Long(Math.round(passedTime * measRemain / i / 1000.0)).intValue();
                uiLabelSLittle.setText(remS + "");
                alTimeLittle.clear();
            }

            // Вычисление оставшегося времени выполнения всей задачи
            if(curRep == numOfRep) { // Если повтор последний, то время такое же, как и на текущую картинку
                uiLabelSBig.setText(uiLabelSLittle.getText());
            }
            else { // Иначе расчет примерного времени
                int remSBig = new Long(Math.round((System.currentTimeMillis() - msBig) / 1000.0 / percentBig * (100.0 - percentBig))).intValue();
                uiLabelSBig.setText(remSBig + "");
            }
        } else { // Иначе крик в консоль об испорченной строке
            System.err.println("Not enough data in measurement \"" + s + "\"");
        }
    }

    void evtReady() { // Ожидание запроса на сканирование
        isReady = true; // Пометить мк как "готовый"
        uiLabelStatus.setText(alCurLocale.get(46)); // Установить статус в "Ожидание запроса на сканирование"
    }

    public void roundTask() { // Округляет сектор сканирования
        final int HOR_BEGIN = Integer.parseInt(uiTextHorBegin.getText());
        final int HOR_END   = Integer.parseInt(uiTextHorEnd  .getText());
        final int HOR_AC    = Integer.parseInt(uiTextHorAc.getText());
        final boolean HOR_UNIT_DEG    = (uiComboHorUnit  .getSelectedIndex() == 0);
        final boolean HOR_AC_UNIT_DEG = (uiComboHorAcUnit.getSelectedIndex() == 0);

        final int VER_BEGIN = Integer.parseInt(uiTextVerBegin.getText());
        final int VER_END   = Integer.parseInt(uiTextVerEnd  .getText());
        final int VER_AC = Integer.parseInt(uiTextVerAc.getText());

//        final int NUM_OF_REP = Integer.parseInt(uiNumOfRep.getText());
//        final boolean MOVING_VER = (uiMovingType.getSelectedIndex() == 0);

        int horTaskBegin, // Координаты по азимуту
            horTaskEnd;
        if(HOR_UNIT_DEG) { // Выбраны градусы
            horTaskBegin = new Long(Math.round(HOR_BEGIN * stepDivDeg)).intValue();
            horTaskEnd   = new Long(Math.round(HOR_END   * stepDivDeg)).intValue();
        } else {           // Выбраны шаги
            horTaskBegin = HOR_BEGIN;
            horTaskEnd   = HOR_END;
        }
        
        int horTaskAc; // Шаг по азимуту
        if(HOR_AC_UNIT_DEG) { // Выбраны градусы
            horTaskAc = new Long(Math.round(HOR_AC * stepDivDeg)).intValue();
        } else {              // Выбраны шаги
            horTaskAc = HOR_AC;
        }

        int verTaskBegin = VER_BEGIN,
            verTaskEnd   = VER_END,
            verTaskAc    = VER_AC;

        horRealBegin = horTaskBegin;
        horRealEnd   = horTaskEnd;
        horRealAc    = horTaskAc;

        verRealBegin = verTaskBegin;
        verRealEnd   = verTaskEnd;
        verRealAc    = verTaskAc;

        /* Нахождение минимальной и максимальной координаты */
        /* Азимут: */
        if(horRealBegin < horRealEnd) { // Min = begin
            horMin = horRealBegin;
            horMax = horRealBegin;
            while(horMax <= horRealEnd)
                horMax += horRealAc;
            horMax -= horRealAc;
        }
        else {                          // Max = begin
            horMax = horRealBegin;
            horMin = horRealBegin;
            while(horMin >= horRealEnd)
                horMin -= horRealAc;
            horMin += horRealAc;
        }
        /* Высота: */
        if(verRealBegin < verRealEnd) { // Min = begin
            verMin = verRealBegin;
            verMax = verRealBegin;
            while(verMax <= verRealEnd)
                verMax += verRealAc;
            verMax -= verRealAc;
        }
        else {                          // Max = begin
            verMax = verRealBegin;
            verMin = verRealBegin;
            while(verMin >= verRealEnd)
                verMin -= verRealAc;
            verMin += verRealAc;
        }

        /* Заполнение таблицы соответствий: координата на сфере - координата пикселя */
        // Для азимута:
        mapHor = new HashMap();
        numOfHor = 0;
        for(int i = horMin; i <= horMax; i += horRealAc) {
            mapHor.put(i, numOfHor);
            numOfHor++;
        }

        // Для высоты:
        mapVer = new HashMap();
        numOfVer = 0;
        for(int i = verMax; i >= verMin; i -= verRealAc) {
            mapVer.put(i, numOfVer);
            numOfVer++;
        }

        if(horMax == horTaskBegin)
            horTaskEnd = horMin;
        else if(horMax == horTaskEnd)
            horTaskBegin = horMin;
        else if(horMin == horTaskBegin)
            horTaskEnd = horMax;
        else if(horMin == horTaskEnd)
            horTaskBegin = horMax;

        if(verMax == verTaskBegin)
            verTaskEnd = verMin;
        else if(verMax == verTaskEnd)
            verTaskBegin = verMin;
        else if(verMin == verTaskBegin)
            verTaskEnd = verMax;
        else if(verMin == verTaskEnd)
            verTaskBegin = verMax;

        /* Занесение результатов округления в форму: */
        uiLabelTaskHorBegin .setText(horTaskBegin + "");
        uiLabelTaskHorEnd   .setText(horTaskEnd   + "");
        uiLabelTaskHorAc    .setText(horTaskAc    + "");
        uiLabelTaskHorUnit  .setText(alCurLocale.get(8));
        uiLabelTaskHorAcUnit.setText(alCurLocale.get(8));

        uiLabelTaskVerBegin .setText(verTaskBegin + "");
        uiLabelTaskVerEnd   .setText(verTaskEnd   + "");
        uiLabelTaskVerAc    .setText(verTaskAc    + "");
        uiLabelTaskVerUnit  .setText(alCurLocale.get(7));
        uiLabelTaskVerAcUnit.setText(alCurLocale.get(7));
    }

    void evtRepeatition(String s) { // Новый повтор
        vStringToArrayOfInt(s); // Разбить строку на массив int
        if (ardStringToArrayOfIntSize >= 2) { // Если верная строка
            curRep = ardStringToArrayOfInt[0];
            numOfRep = ardStringToArrayOfInt[1];
            
            uiLabelCurRep.setText(curRep + "");
            uiLabelTotalRep.setText(numOfRep + "");
        }
        numOfMeas = ((horRange / horRealAc) + 1) * ((verRange / verRealAc) + 1); // Количество измерений в повторе
        uiLabelTotalMeas.setText(numOfMeas + ""); // Вывод кол-ва измерений в повторе
        curMeas = 0; // Сброс сделанного кол-ва измерений
        alMap.clear(); // Сброс текущей карты "коорд. коорд. знач."
        uiLabelStatus.setText(alCurLocale.get(47) + curRep); // Статус в "Начало повтора №"
        alTimeLittle.clear(); // Сброс времен повтора
        timeLittleLastUpdate = System.currentTimeMillis(); // Обновление времени начала повтора
        uiLabelSLittle.setText(alCurLocale.get(48)); // Остаток времени выполнения повтора в "(оценка)"

//        /* Нахождение минимальной и максимальной координаты */
//        /* Азимут: */
//        if(horRealBegin < horRealEnd) { // Min = begin
//            horMin = horRealBegin;
//            horMax = horRealBegin;
//            while(horMax <= horRealEnd)
//                horMax += horRealAc;
//            horMax -= horRealAc;
//        }
//        else {                          // Max = begin
//            horMax = horRealBegin;
//            horMin = horRealBegin;
//            while(horMin >= horRealEnd)
//                horMin -= horRealAc;
//            horMin += horRealAc;
//        }
//        /* Высота: */
//        if(verRealBegin < verRealEnd) { // Min = begin
//            verMin = verRealBegin;
//            verMax = verRealBegin;
//            while(verMax <= verRealEnd)
//                verMax += verRealAc;
//            verMax -= verRealAc;
//        }
//        else {                          // Max = begin
//            verMax = verRealBegin;
//            verMin = verRealBegin;
//            while(verMin >= verRealEnd)
//                verMin -= verRealAc;
//            verMin += verRealAc;
//        }
//
//        /* Заполнение таблицы соответствий: координата на сфере - координата пикселя */
//        mapHor = new HashMap();
//        numOfHor = 0;
//        for(int i = horMin; i <= horMax; i += horRealAc) {
//            mapHor.put(i, numOfHor);
//            numOfHor++;
//        }
//
//        mapVer = new HashMap();
//        numOfVer = 0;
//        for(int i = verMax; i >= verMin; i -= verRealAc) {
//            mapVer.put(i, numOfVer);
//            numOfVer++;
//        }

        /* Создание окна с картинкой */
        curIW = new ImageWindow(numOfHor, numOfVer,horMin,horMax,verMin,verMax);
        // Если все условия верны, то подложить на задний фон предыдущую картинку:
        if(uiCheckCompareMode.isSelected() && haveLastImage && lastImage.getHeight() == curIW.imageHeight && lastImage.getWidth() == curIW.imageWidth) {
            curIW.setImage(lastImage);
        }
    }

    void evtScanned(String s) { // Обработанный мк запрос
        uiLabelStatus.setText(alCurLocale.get(49)); // Статус в "Начало сканирования"
        msBig = System.currentTimeMillis(); // Задать время начала сканирования
    }

    void evtMoving(String s) { // Как будет двигаться мк
        uiLabelStatus.setText(alCurLocale.get(49)); // Статус в "Начало сканирования"
        if(s.contains("Hor")) { // Если для азимута
            vStringToArrayOfInt(s);
            if (ardStringToArrayOfIntSize >= 3) {
//                if(ardStringToArrayOfInt[0] != horRealBegin)
//                    System.err.println("0 - " + ardStringToArrayOfInt[0] + " != " + horRealBegin);
//                if(ardStringToArrayOfInt[1] != horRealEnd)
//                    System.err.println("1 - " + ardStringToArrayOfInt[1] + " != " + horRealBegin);
//                if(ardStringToArrayOfInt[2] != horRealAc)
//                    System.err.println("2 - " + ardStringToArrayOfInt[2] + " != " + horRealAc);

//                horRealBegin = ardStringToArrayOfInt[0];
//                horRealEnd = ardStringToArrayOfInt[1];
//                horRealAc = ardStringToArrayOfInt[2];
//                horRange = Math.abs(horRealBegin-horRealEnd);
//                uiTaskHorBegin.setText(horRealBegin + "");
//                uiTaskHorEnd.setText(horRealEnd + "");
//                uiTaskHorAc.setText(horRealAc + "");
//                if(s.contains("step")) {
//                    uiTaskHorUnit.setText("(шаги)");
//                    uiTaskHorAcUnit.setText("(шаги)");
//                }
//                else {
//                    uiTaskHorUnit.setText("(градусы)");
//                    uiTaskHorAcUnit.setText("(градусы)");
//                }
                horRange = Math.abs(horRealBegin-horRealEnd);
            }
        }
        else if(s.contains("Ver")) { // Иначе если для высоты
            vStringToArrayOfInt(s);
            if (ardStringToArrayOfIntSize >= 3) {
//                if(ardStringToArrayOfInt[0] != verRealBegin)
//                    System.err.println("4 - " + ardStringToArrayOfInt[0] + " != " + verRealBegin);
//                if(ardStringToArrayOfInt[1] != verRealEnd)
//                    System.err.println("5 - " + ardStringToArrayOfInt[1] + " != " + verRealEnd);
//                if(ardStringToArrayOfInt[2] != verRealAc)
//                    System.err.println("6 - " + ardStringToArrayOfInt[2] + " != " + verRealAc);

//                verRealBegin = ardStringToArrayOfInt[0];
//                verRealEnd = ardStringToArrayOfInt[1];
//                verRealAc = ardStringToArrayOfInt[2];
//                verRange = Math.abs(verRealBegin-verRealEnd);
//                uiTaskVerBegin.setText(verRealBegin + "");
//                uiTaskVerEnd.setText(verRealEnd + "");
//                uiTaskVerAc.setText(verRealAc + "");
//                uiTaskVerUnit.setText("(градусы)");
//                uiTaskVerAcUnit.setText("(градусы)");
                verRange = Math.abs(verRealBegin-verRealEnd);
            }
        }


    }

    void evtEnd(String s) throws IOException { // Конец картинки
        uiLabelStatus.setText(alCurLocale.get(50)); // Возвращение на стартовую позицию
        if(!logData.isEmpty()) { // Если лог не пуст
            File f = new File(new File("").getAbsolutePath() + File.separator + timeBegin + "-meas" + curRep + "of" + numOfRep + ".txt");
            if(f.exists()) f.delete(); // Если файл существует - удалить
            f.createNewFile(); // Создать файл лога
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            bufferedWriter.append(logData);
            bufferedWriter.flush();

            logData = ""; // Сбросить лог
            savePic(); // Сохранить картинку
        }
    }

    private void evtPark() { // Парковка
        uiLabelStatus.setText(alCurLocale.get(51)); // Статус в "Парковка завершена, можно отключить питание"
    }

    void savePic() throws IOException { /* Сохранение картинки на диск: */
        
        File outputFile = new File(new File("").getAbsolutePath() + File.separator + timeBegin + "-pic" + curRep + "of" + numOfRep + ".png");
        ImageIO.write(curIW.getImg(), "png", outputFile);

        lastImage = curIW.getImg(); // Предыдущая картинка = текущей
        haveLastImage = true; // Имеется предыдущая картика
        
    }

    void updatePic(int horCord, int verCord, int value) { /* Добавление пикселя на картинку: */
        
        BufferedImage bi = curIW.getImg();

        final int cordX = Integer.parseInt(mapHor.get(horCord).toString());
        final int cordY = Integer.parseInt(mapVer.get(verCord).toString());
        bi.setRGB(cordX, cordY, value);

        /* Вывод картинки на экран: */
        curIW.setImage(bi);
        
    }

    class ImageWindow { // Окно с картинкой
        int imageWidth;
        int imageHeight;
        BufferedImage imgSrc;
        JFrame mainFrame;
        ImageIcon image;
        JLabel info,label;
        JPanel mainPanel,butPanel,imgPanel;
        JButton plus,minus;
        int zoomLevel = 1;

        public ImageWindow(int x, int y, int minX, int maxX, int minY, int maxY) {
            imageWidth = x;
            imageHeight = y;

            mainFrame = new JFrame(timeBegin + "-pic" + curRep + "of" + numOfRep + ".png");


            for(zoomLevel = 1; 2*zoomLevel*y < 600 && 2*zoomLevel*x < 600; zoomLevel*=2) {} // Какой-то подгон размера картинки до размера окна (600х400)

            mainFrame.setBounds(700, 0, Math.max(x*zoomLevel + 50,400), y*zoomLevel + 100);
            /* Добавление компонентов в окно: */ {
                /* Главная панель на главный фрейм: */
                mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());
                mainFrame.add(mainPanel);

                /* Панель кнопок на главную панель: */
                butPanel = new JPanel();
                mainPanel.add(butPanel, BorderLayout.NORTH);

                /* Кнопки на панель кнопок: */
                plus = new JButton("+");
                butPanel.add(plus);
                minus = new JButton("-");
                butPanel.add(minus);

                /* Метка информации на панель кнопок: */
                info = new JLabel(alCurLocale.get(52) + minX + alCurLocale.get(53) + maxX + alCurLocale.get(54) +
                        alCurLocale.get(55) + minY + alCurLocale.get(56) + maxY + alCurLocale.get(57));
                butPanel.add(info);

                /* Панель картинки на главную панель: */
                imgPanel = new JPanel();
                mainPanel.add(imgPanel, BorderLayout.CENTER);

                /* Картинка на панель картинки: */
                label = new JLabel();
                imgPanel.add(label);
            }

            /* Установка слушателей кнопок: */ {
                plus.addActionListener(new ActionListener() { // Открыть файл
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        zoomLevel*=2;
                        resizeImage();
                    }
                });
                minus.addActionListener(new ActionListener() { // Открыть файл
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(zoomLevel>1)
                            zoomLevel/=2;
                        resizeImage();
                    }
                });
            }
            resetImage();
            mainFrame.setVisible(true);
        }

        private void resetImage() {
            BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_USHORT_GRAY);

            for(int i = 0; i < imageWidth; i++)
                for(int j = 0; j < imageHeight; j++)
                    bi.setRGB(i, j, 65535); // Пиксель в белый цвет

            setImage(bi);
        }

        public void setImage(BufferedImage i) {
            imgSrc = i;
            resizeImage();
        }

        private void resizeImage() {
            int newImageWidth = imageWidth * zoomLevel;
            int newImageHeight = imageHeight * zoomLevel;

            BufferedImage resizedImage = createResizedCopy(imgSrc,newImageWidth,newImageHeight);

            image = new ImageIcon(resizedImage);
            label.setIcon(image);
        }

        private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
            BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_USHORT_GRAY);
            Graphics2D g = scaledBI.createGraphics();
            g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
            g.dispose();
            return scaledBI;
        }

        public BufferedImage getImg() {
            return imgSrc;
        }
    }

    int ardStringToArrayOfInt[];
    int ardStringToArrayOfIntSize;

    void vStringToArrayOfInt(final String s) { // Заполнение ardStringToArrayOfInt[]
        char tmp; // Временная переменная для хранения текущего символа
        ArrayList<Integer> ar = new ArrayList();
        for (int i = 0, j; i < s.length(); i++) { // Пробежка по строке посимвольно
            tmp = s.charAt(i);
            if (Character.isDigit(tmp) || tmp == '-') { // Условие для поиска начала int
                if(s.charAt(i) == '-' && !Character.isDigit(s.charAt(i+1))) // Если минус и не цифра, значит это не число -- пропуск
                    continue;
                for (j = i + 1; j < s.length(); j++) {
                    tmp = s.charAt(j);
                    if (!Character.isDigit(tmp)) { // Условие для поиска конца double
                        ar.add(Integer.parseInt(s.substring(i, j)));
                        i = j;
                        break;
                    }
                }
                if (j == s.length()) { // Дошли до конца строки?
                    ar.add(Integer.parseInt(s.substring(i, s.length())));
                    i = j;
                }
            }
        }

        ardStringToArrayOfInt = new int[ar.size()]; // Заполнение глобального массива
        for (int i = 0; i < ardStringToArrayOfInt.length; i++) {
            ardStringToArrayOfInt[i] = ar.get(i);
        }
        ardStringToArrayOfIntSize = ar.size();
    }
}