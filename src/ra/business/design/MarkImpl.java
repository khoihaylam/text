package ra.business.design;

import java.util.Scanner;

public interface MarkImpl extends IOData {
    @Override
    void inputData(Scanner scanner);

    @Override
    void outputData();
}
