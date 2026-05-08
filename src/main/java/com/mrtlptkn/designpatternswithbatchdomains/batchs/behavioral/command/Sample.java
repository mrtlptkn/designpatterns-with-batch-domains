package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command;

public class Sample {

    public interface Command {
        void execute();
    }

    // Command ile çalışan nesn
    public class Light {

        public void turnOn() {
            System.out.println("Light ON");
        }

        public void turnOff() {
            System.out.println("Light OFF");
        }
    }

    public class LightOnCommand implements Command {

        private final Light light; // Step

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    public class LightOffCommand implements Command {

        private final Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Bu yapıda command sınıfları ile etkileşime geçeriz.
    // Controllerda yazılan Test kodu
    public class RemoteControl {

        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }
}


