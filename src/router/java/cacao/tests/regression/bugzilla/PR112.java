/* tests/regression/bugzilla/PR112.java

   Copyright (C) 2008
   CACAOVM - Verein zur Foerderung der freien virtuellen Maschine CACAO

   This file is part of CACAO.

   This program is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License as
   published by the Free Software Foundation; either version 2, or (at
   your option) any later version.

   This program is distributed in the hope that it will be useful, but
   WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
   02110-1301, USA.

*/


import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.*;

public class PR112 {
    @Test ( expected = IllegalArgumentException.class )
    public void test() throws IllegalArgumentException {
        // Derived from OpenJDK's jdk jtreg test
        // java/lang/reflect/Array/ExceedMaxDim.java
        Object o = Array.newInstance(Integer.TYPE, 0);

        for (int i = 1; i <= 254; i++) {
            o = Array.newInstance(o.getClass(), 1);
        }

        o = Array.newInstance(o.getClass(), 1);
    }
}
