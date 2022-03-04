package factory.simplefactory;

public class PhoneFactory {

   private Phone phone = null;

    Phone makePhone(String type) {

        switch (type) {
            case "小米":
                this.phone = new XMPhone(type);
                break;
            case "华为":
                this.phone = new HWPhone(type);
                break;

        }

        return phone;
    }

}
