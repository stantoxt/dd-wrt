/* RemoteRef.java --
   Copyright (c) 1996, 1997, 1998, 1999, 2004, 2006
   Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */


package java.rmi.server;

import java.io.Externalizable;
import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Represents a handler to the remote object. Each instance of the
 * {@link RemoteStub} contains such handler and uses it to invoke remote
 * methods via {@link #invoke(Remote, Method, Object[], long)}.
 */
public interface RemoteRef extends Externalizable
{
  /**
   *  Indicates compatibility with JDK 1.1.*
   */
  long serialVersionUID = 3632638527362204081L;

  /**
   * For binary compatibility with the JDK, the string "sun.rmi.server".
   * Not actually used for anything.
   */
  String packagePrefix = "sun.rmi.server";

  /**
   * @deprecated use {@link #invoke(Remote, Method, Object[], long)} instead.
   */
  void invoke (RemoteCall call) throws Exception;

  /**
   * Invoke a method. This method either returns the result of remote invocation
   * or throws RemoteException if the remote call failed. Other exceptions may
   * be thrown if some problem has occured in the application level.
   *
   * @param obj the object, containing the remote reference (for instance,
   *          remote stub, generated by rmic).
   * @param method the method to invoke
   * @param params the method parameters
   * @param methodHash a persistent hash code that can be used to represent a
   *          method
   * @return the result of the remote invocation
   * @throws RemoteException if the remote call has failed
   * @throws Exception if one is raised at the application level
   */
  Object invoke (Remote obj, Method method, Object[] params, long methodHash)
    throws Exception;

  /**
   * @deprecated use {@link #invoke(Remote, Method, Object[], long)} instead.
   */
  RemoteCall newCall (RemoteObject obj, Operation[] op, int opnum, long hash)
    throws RemoteException;

  /**
   * @deprecated use {@link #invoke(Remote, Method, Object[], long)} instead.
   */
  void done (RemoteCall call) throws RemoteException;

  /**
   * Compare two remote objects for equality. The references are equal if
   * they point to the same remote object.
   *
   * @param ref the reference to compare.
   *
   * @return true if this and passed references both point to the same remote
   * object, false otherwise.
   */
  boolean remoteEquals (RemoteRef ref);

  /**
   * Get the hashcode for a remote object. Two remote object stubs, referring
   * to the same remote object, have the same hash code.
   *
   * @return the hashcode of the remote object
   */
  int remoteHashCode();


  /**
   * Returns the class name of the reference type that must be written to the
   * given stream. When writing, this returned name is passed first, and
   * the reference.writeExternal(out) writes the reference specific data.
   *
   * @param out the stream, where the data must be written
   *
   * @return the class name.
   */
  String getRefClass (ObjectOutput out);

  /**
   * Get the string representation of this remote reference.
   *
   * @return the string representation.
   */
  String remoteToString();
}
