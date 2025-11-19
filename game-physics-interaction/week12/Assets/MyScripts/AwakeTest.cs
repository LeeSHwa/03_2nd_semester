using UnityEngine;

public class AwakeTest : MonoBehaviour
{

    private void Awake()
    {
        Debug.Log("Awake");
    }
    void Start()
    {
        Debug.Log("Start");

    }

    // Update is called once per frame
    void OnEnable()
    {
        Debug.Log("Enable");
    }
}
