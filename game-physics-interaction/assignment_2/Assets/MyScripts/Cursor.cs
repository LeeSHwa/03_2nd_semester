using UnityEngine;

public class Cursor : MonoBehaviour
{
    int num = 0;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {

        if (Input.GetKeyUp(KeyCode.V))
            {
            Debug.Log(Input.mousePosition);
            }

        if (Input.GetKeyDown(KeyCode.Return))
        {
            num++;
            Debug.Log(num);
        }

        if (Input.GetMouseButtonUp(1))
        {
            num--;
            Debug.Log(num);
        }
    }
}
