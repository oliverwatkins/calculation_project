package com.bluewalrus.calculationBuilderProject.ui.operator;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author WatkinsO
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SimpleTransferable implements Transferable {

    private Object source;
    private DataFlavor[] flavors;

    public SimpleTransferable(Object object) {
        flavors = new DataFlavor[1];
        flavors[0] = new DataFlavor(object.getClass(), "????");

        source = object;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (int i = 0; i < flavors.length; i++) {
            if (flavor.match(flavors[i])) {
                return true;
            }
        }
        return false;
    }

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return source;
    }
}
