package com.revenco.daemon.natives;

import android.content.Context;

/**
 * 
 * @author Mars
 *
 */
public interface IDaemonClient {
	/**
	 * override this method by {@link android.app.Application}</br></br>
	 * ****************************************************************</br>
	 * <b>DO super.attchBaseContext() first !</b></br>
	 * ****************************************************************</br>
	 * 
	 * @param base
	 */
	void onAttachBaseContext(Context base);
}