package ra.business.design;

import java.util.Scanner;

public interface StudentImpl extends IOData {
    @Override
    void inputData(Scanner scanner);
    @Override
    void outputData();
}
