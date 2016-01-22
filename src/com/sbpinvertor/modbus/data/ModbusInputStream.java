package com.sbpinvertor.modbus.data;

import com.sbpinvertor.modbus.utils.DataUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (c) 2015-2016 JSC "Zavod "Invertor"
 * [http://www.sbp-invertor.ru]
 * <p/>
 * This file is part of JLibModbus.
 * <p/>
 * JLibModbus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */
abstract public class ModbusInputStream extends InputStream {
    abstract public int read() throws IOException;

    abstract public int read(byte[] b, int off, int len) throws IOException;

    public int readShortBE() throws IOException {
        int h = read();
        int l = read();
        if (-1 == h || -1 == l)
            return -1;
        return DataUtils.toShort(h, l);
    }

    public int readShortLE() throws IOException {
        int l = read();
        int h = read();
        if (-1 == h || -1 == l)
            return -1;
        return DataUtils.toShort(h, l);
    }
}