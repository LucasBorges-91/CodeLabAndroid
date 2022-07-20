package br.com.portal.affirmations

import android.content.Context
import br.com.portal.affirmations.adapter.ItemAdapter
import br.com.portal.affirmations.model.Affirmation
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {

    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
        )

        val adapter = ItemAdapter( context, data )
        assertEquals("Itemadapter is not correct size!", data.size, adapter.itemCount )
    }
}