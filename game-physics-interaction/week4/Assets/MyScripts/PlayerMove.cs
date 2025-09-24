using UnityEngine;

public class PlayerMove : MonoBehaviour
{
    int i = 0
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

        if (Input.GetKeyDown(KeyCode.Alpha2))
        {
            Debug.Log("2(@) is pressed down!!");
        }
        if (Input.GetKeyUp(KeyCode.Alpha2))
        {
            Debug.Log("2(@) is pressed up !!");
        }
        if (Input.GetMouseButtonDown(0))
        {
            Debug.Log("mouse left is preesed down");
        }
        if (Input.GetMouseButtonUp(0))
        {
            Debug.Log("mouse left is preesed up");
        }
    }
}
