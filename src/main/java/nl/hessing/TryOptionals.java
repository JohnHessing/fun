package nl.hessing;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryOptionals {

    public static void main(String[] args) {
        new TryOptionals().doIt();
    }

    private void doIt() {

        System.out.println(Optional.of("test"));

        System.out.println(Optional.of("string").map(str -> Optional.of("STRING")));

        System.out.println(Optional.of("string").flatMap(s -> Optional.of("STRING")));

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(myList);

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));


//        Computer computer = new Computer();
//        SoundCard soundCard = new SoundCard();
//        USB usb = new USB();
//
//        computer.setSoundCard(Optional.ofNullable(soundCard));
//        soundCard.setUsb(Optional.ofNullable(usb));
//        usb.setName("Bla");
//
//        System.out.println("USB naam: " + computer.getSoundCard().flatMap(SoundCard::getUsb).map(USB::getName).flatMap(USBType::getName).orElse("Geen USB poort"));
    }


    class Computer {
        private String name;
        private Optional<SoundCard> soundCard;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<SoundCard> getSoundCard() {
            return soundCard;
        }

        public void setSoundCard(Optional<SoundCard> soundCard) {
            this.soundCard = soundCard;
        }
    }

    class SoundCard {
        private String name;
        private Optional<USB> usb;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<USB> getUsb() {
            return usb;
        }

        public void setUsb(Optional<USB> usb) {
            this.usb = usb;
        }
    }

    class USB {
        private String name;
        private Optional<USBType> UsbType;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<USBType> getUsbType() {
            return UsbType;
        }

        public void setUsbType(Optional<USBType> usbType) {
            UsbType = usbType;
        }
    }

    class USBType {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
